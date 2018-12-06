package jp.co.rakus.ecommerce_b;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.User;

@Configuration
@EnableBatchProcessing
public class Batch {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	// Reader
	/**
	 * csvファイルからデータを取得.
	 * 
	 * @return
	 */
	@Bean
	public FlatFileItemReader<ItemsForBatch> reader() {

		FlatFileItemReader<ItemsForBatch> reader = new FlatFileItemReader<ItemsForBatch>();
		// reader.setResource(new ClassPathResource("ItemsForBatch_price.csv"));
		reader.setResource(new ClassPathResource("items_sample.csv"));
		reader.setLineMapper(new DefaultLineMapper<ItemsForBatch>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", "name", "description", "priceM", "priceL", "imagePath",
								"deleted" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<ItemsForBatch>() {
					{
						setTargetType(ItemsForBatch.class);
					}
				});
			}
		});

		return reader;
	}
	
	private static final RowMapper<Order> ORDER_RowMapper = (rs, i) -> {

		Order order = new Order();
		order.setId(rs.getInt("o_id"));
		order.setUserId(rs.getInt("o_user_id"));
		order.setStatus(rs.getInt("o_status"));
		order.setTotalPrice(rs.getInt("o_total_price"));
		
		User user = new User();
		user.setId(rs.getInt("u_id"));
		user.setName(rs.getString("u_name"));
		user.setEmail(rs.getString("u_email"));
		
		order.setUser(user);//←orderにuserを入れている
		return order;
	};
	
	
	/*private static final String orderSql = "SELECT id,user_id,status,total_price FROM orders ORDER BY id";*/
	private static final String orderSql = "select \r\n" + 
			"o.id AS o_id , o.user_id AS o_user_id, o.status AS o_status, o.total_price AS o_total_price,\r\n" + 
			"u.id AS u_id, u.name AS u_name, u.email AS u_email \r\n" + 
			"from orders o \r\n" + 
			"inner join users u \r\n" + 
			"on o.user_id = u.id \r\n" + 
			"order by o.total_price desc;\r\n";

	/**
	 * DBから注文情報を取得.
	 * 
	 * @return
	 */
	@Bean
	public JdbcCursorItemReader<Order> readerOrder() {
		JdbcCursorItemReader<Order> readerOrder = new JdbcCursorItemReader<>();
		readerOrder.setDataSource(dataSource);
		readerOrder.setSql(orderSql);
		readerOrder.setRowMapper(ORDER_RowMapper);

		return readerOrder;
	}

	// Processor
	/*
	 * @Bean public ItemsForBatchItemProcessor processor() { return new
	 * ItemsForBatchItemProcessor(); }
	 */

	// Writer
	@Bean
	public JdbcBatchItemWriter<ItemsForBatch> writer() {
		JdbcBatchItemWriter<ItemsForBatch> writer = new JdbcBatchItemWriter<ItemsForBatch>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ItemsForBatch>());
		writer.setSql(
				"INSERT INTO items (id, name , description, price_m, price_l, image_path, deleted) VALUES (:id, :name , :description, :priceM, :priceL, :imagePath, :deleted)");
		writer.setDataSource(dataSource);
		return writer;
	}
	
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

	String date = LocalDate.now().format(format);

	
	
	/**
	 * 注文情報をcsvファイルに書き込み.
	 * 
	 * @return
	 */
	@Bean
	public FlatFileItemWriter<Order> writerCsv() {
		FlatFileItemWriter<Order> writerCsv = new FlatFileItemWriter<Order>();
		writerCsv.setResource(new FileSystemResource(
				"C:\\env\\app\\springworkspace2\\batch\\src\\main\\resources\\order_"+date+".csv"));
		writerCsv.setEncoding("SJIS");
		writerCsv.setAppendAllowed(true);
		writerCsv.setLineAggregator(new ECAggregator());

		return writerCsv;
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobStartEndLIstener(new JdbcTemplate(dataSource));
	}

	// ステップ１
	@Bean
	public Step step1() {
		return stepBuilderFactory
				.get("step1")
				.<Order, Order>chunk(10)
				/* .<ItemsForBatch,ItemsForBatch> chunk(10) */
				.reader(readerOrder())
				/* .processor(processor()) */
				.writer(writerCsv()).build();
	}

	/*
	 * // ステップ２
	 * 
	 * @Bean public Step step2() { return stepBuilderFactory.get("step2")
	 * .<ItemsForBatch,ItemsForBatch> chunk(10) .reader(reader())
	 * .processor(processor()) .writer(writer()) .build(); }
	 */

	// ジョブ
	@Bean
	public Job testJob() {
		return jobBuilderFactory
				.get("testJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.flow(step1())
				/* .next(step2()) */
				.end().build();
	}
}

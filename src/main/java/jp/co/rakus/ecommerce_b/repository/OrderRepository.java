package jp.co.rakus.ecommerce_b.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Order;

@Repository
public class OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private SimpleJdbcInsert insert;
	
	private static final RowMapper<Order> ORDER_ROW_MAPPER = (rs, i) -> {
		Order order = new Order();
		order.setId(Integer.parseInt(rs.getString("id")));
		order.setUserId(Integer.parseInt(rs.getString("user_id")));
		order.setTotalPrice(Integer.parseInt(rs.getString("total_price ")));
		order.setOrderDate(rs.getDate("order_date "));
		order.setDestinationName(rs.getString("destination_name "));
		order.setDestinationEmail(rs.getString("destination_email "));
		order.setDestinationZipcode(rs.getString("destination_zipcode "));
		order.setDestinationAddress(rs.getString("destination_address"));
		order.setDestinationTel(rs.getString("destination_tel"));
		order.setDeliverlyTime(rs.getTimestamp("delivery_time"));// timestap型
		order.setPaymentMethod(Integer.parseInt("payment_method "));
		return order;
	};
	

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("orders");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}

	public Order save(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);

		if (order.getId() == null) {
			Number key = insert.executeAndReturnKey(param);
			order.setId(key.intValue());
		} else {
			String upDateSql = "UPDATE orders SET user_id=:userId ,status=:status,total_price=:totalPrice,order_date=:orderDate,destination_name=:destinationName,"
					+ "destination_email=:destinationEmail,destination_zipcode=:destinationZipcode,destination_address=:destinationAddress,destination_tel=:destinationTel,"
					+ "delivery_time=:deliverlyTime,payment_method=:paymentMethod where id=:id";
			template.update(upDateSql, param);
		}
		return order;
	}
}

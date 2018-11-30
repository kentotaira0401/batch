package jp.co.rakus.ecommerce_b.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.OrderItem;

@Repository
//FIXME:javadoc漏れ
public class OrderItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("order_items");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}

	public OrderItem insert(OrderItem orderItem) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);

		Number key = insert.executeAndReturnKey(param);
		orderItem.setId(key.intValue());
		return orderItem;
	}
	
	/**
	 * 受け取ったorderItemIdを元にorder_itemsテーブルからデータ削除.
	 * 
	 * @param id
	 *            orderItemId
	 */
	public void deleteByOrderItemId(Integer id) {
		String sql = "delete from order_items where id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);

	}
	/**
	 * 受け取ったorderItemIdを元にorder_toppingsテーブルからデータ削除.
	 * 
	 * @param id
	 *            order_toppings
	 */
	public void deleteToppingByOrderItemId(Integer id) {
		String sql = "delete from order_toppings where order_item_id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);

	}
	
}

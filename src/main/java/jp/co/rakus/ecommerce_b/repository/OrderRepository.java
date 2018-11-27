package jp.co.rakus.ecommerce_b.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.OrderItem;
import jp.co.rakus.ecommerce_b.domain.OrderTopping;
import jp.co.rakus.ecommerce_b.domain.Topping;

@Repository
public class OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("orders");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}

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

	private final static ResultSetExtractor<Order> ORDER_RESULTSETEXTRACTOR = (rs) -> {

		Order order = null; // 注文情報が入る箱を nullに。
	
		OrderItem orderItem = null; // pizza１種類の情報が入るものをnull に。
		List<OrderItem> orderItemList = null;
		List<OrderTopping> orderToppingList = null; // topping が複数入る箱を用意。
		int beforOrderId = 0; // 注文が切り替わったら、変更
		int beforeorderItemId = 0; // pizza1種類が切り替わったら変更
		int beforeOrderToppingId = 0;
		while (rs.next()) {

			if (rs.getInt("ord_id") != beforOrderId) {
				order = new Order();
				order.setId(rs.getInt("ord_id"));
				order.setUserId(rs.getInt("ord_user_id"));
				order.setStatus(rs.getInt("ord_status"));
				order.setTotalPrice(rs.getInt("ord_total_price"));

				String stringValueOfOrderDate = rs.getString("ord_order_date");
				if(!(stringValueOfOrderDate == null)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				Date formatOrderDate = null;
				try {
					formatOrderDate = sdf.parse(stringValueOfOrderDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				order.setOrderDate(formatOrderDate);
				}

				order.setDestinationName(rs.getString("ord_destination_name"));
				order.setDestinationEmail(rs.getString("ord_destination_email"));
				order.setDestinationZipcode(rs.getString("ord_destination_zipcode"));
				order.setDestinationAddress(rs.getString("ord_destination_address"));
				order.setDestinationTel(rs.getString("ord_destination_tel"));
				order.setDeliverlyTime(rs.getTimestamp("ord_deliverly_time"));
				order.setPaymentMethod(rs.getInt("ord_payment_method"));

				orderItemList = new ArrayList<OrderItem>();
				order.setOrderItemList(orderItemList);
				beforOrderId = rs.getInt("ord_id");
			}

			if (rs.getInt("ordI_id") != beforeorderItemId) { // pizza1種類の情報が変われば処理を行う。
				orderItem = new OrderItem(); // pizza1種類の情報。
				orderItem.setId(rs.getInt("ordI_id"));
				orderItem.setItemId(rs.getInt("ordI_item_id"));
				orderItem.setOrderId(rs.getInt("ordI_order_id"));
				orderItem.setQuantity(rs.getInt("ordI_quantity"));

				String stringValueOfsize = rs.getString("ordI_size");
				if(!(stringValueOfsize == null)) {
				char charValueOfSize[] = stringValueOfsize.toCharArray();
				orderItem.setSize(charValueOfSize[0]);
				}
				Item item = new Item();
				item.setId(rs.getInt("i_id"));
				item.setName(rs.getString("i_name"));
				item.setDescription(rs.getString("i_description"));
				item.setPriceM(rs.getInt("i_priceM"));
				item.setPriceL(rs.getInt("i_priceL"));
				item.setImagePath(rs.getString("i_imagePath"));
				item.setDeleted(rs.getBoolean("i_deleted"));
				orderItem.setItem(item);

				orderToppingList = new ArrayList<OrderTopping>();// 複数のtoppingが入る箱を用意
				orderItem.setOrderToppingList(orderToppingList);// toppingを入れるための空の箱をセット
				orderItemList.add(orderItem); // pizza1種類の情報とtoppingの情報を詰まったorderItemをaddする。

				beforeorderItemId = orderItem.getId();

			}

			if (rs.getInt("ot_id") != beforeOrderToppingId) {
				OrderTopping orderTopping = new OrderTopping();
				orderTopping.setId(rs.getInt("ot_id"));
				orderTopping.setToppingId(rs.getInt("ot_topping_id"));
				orderTopping.setOrderItemId(rs.getInt("ot_order_item_id"));

				Topping topping = new Topping();
				topping.setId(rs.getInt("t_id"));
				topping.setName(rs.getString("t_name"));
				topping.setPriceM(rs.getInt("t_priceM"));
				topping.setPriceL(rs.getInt("t_priceL"));
				orderTopping.setTopping(topping);
				orderToppingList.add(orderTopping); // toppingを追加

				beforeOrderToppingId = orderTopping.getId(); // pizzaが次の種類に行った時
			}
		}
		return order;
	};

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

	public Order findByUserIdAndStatus(int userId,int status) {
		String sql = "select\r\n" + " ord.id ord_id\r\n" + ",ord.user_id ord_user_id\r\n" + ",ord.status ord_status\r\n"
				+ ",ord.total_price ord_total_price\r\n" + ",ord.order_date ord_order_date\r\n"
				+ ",ord.destination_name ord_destination_name\r\n" + ",ord.destination_email ord_destination_email\r\n"
				+ ",ord.destination_zipcode ord_destination_zipcode\r\n"
				+ ",ord.destination_address ord_destination_address\r\n"
				+ ",ord.destination_tel ord_destination_tel\r\n" + ",ord.delivery_time ord_deliverly_time\r\n"
				+ ",ord.payment_method ord_payment_method\r\n" + ",ordI.id ordI_id\r\n"
				+ ",ordI.item_id ordI_item_id\r\n" + ",ordI.order_id ordI_order_id\r\n"
				+ ",ordI.quantity ordI_quantity\r\n" + ",ordI.size ordI_size\r\n" + ",i.id i_id\r\n"
				+ ",i.name i_name\r\n" + ",i.description i_description\r\n" + ",i.price_m i_priceM\r\n"
				+ ",i.price_l i_priceL\r\n" + ",i.image_path i_imagePath\r\n" + ",i.deleted i_deleted\r\n"
				+ ",ot.id ot_id\r\n" + ",ot.topping_id ot_topping_id\r\n" + ",ot.order_item_id ot_order_item_id\r\n"
				+ ",t.id t_id\r\n" + ",t.name t_name\r\n" + ",t.price_m t_priceM\r\n" + ",t.price_l t_priceL\r\n"
				+ "from\r\n" + "orders as ord\r\n" + "inner join\r\n" + "order_Items as ordI\r\n" + "on\r\n"
				+ "ord.id = ordI.order_id \r\n" + "inner join\r\n" + "items as i\r\n" + "on\r\n"
				+ "ordI.item_id = i.id \r\n" + "inner join\r\n" + "order_toppings as ot\r\n" + "on\r\n"
				+ "ordI.id = ot.order_item_id \r\n" + "inner join\r\n" + "toppings as t\r\n" + "on\r\n"
				+ "ot.topping_id = t.id\r\n" + "where ord.user_id = :user_id and status =:status order by ord.id;";

		SqlParameterSource sqlParam = new MapSqlParameterSource().addValue("user_id", userId).addValue("status", status);
		
		Order order =template.query(sql, sqlParam, ORDER_RESULTSETEXTRACTOR);
		
		return order;
	}
}

package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;

@Service
public class OrderService {
		
	/*
	@Autowired
	public OrderRepository repository;
	*/
	
	/*
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
	*/
	

	/* 齊藤さんと作成
	 * 未入金の order を取得する.
	 * @return 未入金の orderを返す.
	 
	public Order findByUserIdAndStatus(user_id,status) {
		return null;
	}
	*/
	
	/**
	 * 注文をDBに保存する update を呼び出す.
	 * 
	 * @param order 注文情報が詰まっている.
	 * @return 注文情報を返す.
	 
	public Order update(Order order) {
		return repository.update(order);
	}
	
	*/
	
	
	
	
}

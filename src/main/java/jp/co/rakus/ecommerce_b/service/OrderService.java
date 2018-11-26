package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;

@Service
public class OrderService {
		
	
	@Autowired
	public OrderRepository repository;
	
	/* 齊藤さんと作成
	 * 未入金の order を取得する.
	 * @return 未入金の orderを返す.
	 */
	public Order findByUserIdAndStatus() {
		return null;
	}
	
	/*
	 * 注文をDBに保存する update を呼び出す.
	 * 
	 * @param order 注文情報が詰まっている.
	 * @return 注文情報を返す.
	 */
	public Order save(Order order) {
		return repository.save(order);
	}

	
	
	
}

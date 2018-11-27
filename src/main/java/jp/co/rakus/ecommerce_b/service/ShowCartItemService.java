package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;

@Service
public class ShowCartItemService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findByUserIdAndStatus(int userId, int status) {

		List<Order> orderList = orderRepository.findByUserIdAndStatus(userId, status);
		return orderList;
	}

}

package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;

@Service
public class ShowCartItemService {

	@Autowired
	private OrderRepository orderRepository;

	public Order findByUserIdAndStatus(int userId, int status) {

		Order order = orderRepository.findByUserIdAndStatus(userId, status);
		return order;

	}

}

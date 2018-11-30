package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.repository.OrderItemRepository;

@Service
//FIXME:javadoc漏れ
public class DeleteCartItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	
	public void deleteByOrderItemId(Integer orderItemId) {
		orderItemRepository.deleteByOrderItemId(orderItemId);
		orderItemRepository.deleteToppingByOrderItemId(orderItemId);
	}
}

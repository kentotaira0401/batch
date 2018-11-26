package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.OrderItem;
import jp.co.rakus.ecommerce_b.domain.OrderTopping;
import jp.co.rakus.ecommerce_b.form.PutItemIntoCartForm;
import jp.co.rakus.ecommerce_b.repository.OrderItemRepository;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;
import jp.co.rakus.ecommerce_b.repository.OrderToppingRepository;

@Service
public class PutItemIntoCartService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private OrderToppingRepository orderToppingRepository;

	public void putItemIntoCart(PutItemIntoCartForm form) {

		int userId = 1;
		int status = 0;
		List<Order> orderList = orderRepository.findByUserIdAndStatus(userId, status);
		if (orderList.get(0) == null) {
			Order order = new Order();
			// セッションから取り出したユーザーIDをorderオブジェクトにセットする
			order.setUserId(1);
			order.setStatus(0);
			order.setTotalPrice(0);
			order = orderRepository.save(order);
		} else {
			Order order = orderList.get(0);
			OrderItem orderItem = new OrderItem();
			orderItem.setItemId(form.getIntValueOfItemId());
			orderItem.setQuantity(form.getIntValueOfQuantity());
			orderItem.setOrderId(order.getId());
			orderItem.setSize(form.getSize());
			orderItem = orderItemRepository.insert(orderItem);
			List<String> toppings = form.getToppingList();
			for (String topping : toppings) {
				OrderTopping ordertopping = new OrderTopping();
				int toppingId = Integer.parseInt(topping);
				ordertopping.setToppingId(toppingId);
				ordertopping.setOrderItemId(orderItem.getId());
				ordertopping = orderToppingRepository.insert(ordertopping);
			}
		}

	}
}

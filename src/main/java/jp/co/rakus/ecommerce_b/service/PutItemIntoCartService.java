package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
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
	@Autowired 
	private HttpSession session;
	
	public void putItemIntoCart(PutItemIntoCartForm form, LoginUser loginUser) {

		int status = 0;
		int userId = 0;
		
		if(loginUser == null){ //ユーザがログインしてなかった場合。
			  userId = session.getId().hashCode();
		}else {
			  userId = loginUser.getUser().getId();// ログインユーザid;
		}
		
		System.out.println("tmpUserId"+userId);
		
		Order order = orderRepository.findByUserIdAndStatus(userId, status);
		if (order == null) {
			order = new Order();
			order.setStatus(0);
			order.setTotalPrice(0);
			order.setUserId(userId);
			order = orderRepository.save(order);
		}

		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(form.getIntValueOfItemId());
		orderItem.setQuantity(form.getIntValueOfQuantity());
		orderItem.setOrderId(order.getId());
		orderItem.setSize(form.getSize());
		orderItem = orderItemRepository.insert(orderItem);
		List<String> toppings = form.getToppingList();
		if ((!toppings.isEmpty())) {
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

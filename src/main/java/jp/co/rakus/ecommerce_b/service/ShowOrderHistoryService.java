package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;

@Service
//FIXME:javadoc漏れ
public class ShowOrderHistoryService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> showOrderhistory(@AuthenticationPrincipal LoginUser loginUser) {
		
		int [] status = {1,2,3};
		int userId = loginUser.getUser().getId();// ログインユーザid
		List<Order> orderList = orderRepository.findByUserIdAndStatusForOrderHistory(userId, status);
		
		
		return orderList;
	}
	
}

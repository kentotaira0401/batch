package jp.co.rakus.ecommerce_b.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.service.ShowOrderHistoryService;

@Controller
@RequestMapping("/showOrderHistory")
public class ShowOrderHistoryController {

	
	@Autowired
	private ShowOrderHistoryService showOrderHistoryService;
	
	@RequestMapping("/notPaymentOrderHistory")
	public String shownotPaymentOrderHistory(Model model , @AuthenticationPrincipal LoginUser loginUser) {
		
		List<Order> orderList = showOrderHistoryService.showOrderhistory(loginUser);
		
		List<Order> notPaymentOrderList = new ArrayList<>();
		for (Order order : orderList) {
			if(order.getStatus()==1) {
				notPaymentOrderList.add(order);
			}
		}
		model.addAttribute("notPaymentOrderList",notPaymentOrderList);
		
		return "not_payment_order_history";
	}
	
	@RequestMapping("/paidOrderHistory")
	public String showpaidOrderHistory(Model model , @AuthenticationPrincipal LoginUser loginUser) {
		
		List<Order> orderList = showOrderHistoryService.showOrderhistory(loginUser);
		
		
		List<Order> paidOrderList = new ArrayList<>();
		for (Order order : orderList) {
			if(order.getStatus()==2) {
				paidOrderList.add(order);
			}
		}
	
		model.addAttribute("paidOrderList",paidOrderList);
		
		return "paid_order_history";
	}
	
	@RequestMapping("/alreadySentOrderHistory")
	public String showalreadySentOrderHistory(Model model , @AuthenticationPrincipal LoginUser loginUser) {
		
		List<Order> orderList = showOrderHistoryService.showOrderhistory(loginUser);
		
		List<Order> alreadySentOrderList = new ArrayList<>();
		for (Order order : orderList) {
			if(order.getStatus()==3) {
				alreadySentOrderList.add(order);
			}
		}

		model.addAttribute("alreadySentOrderList",alreadySentOrderList);
		
		return "already_sent_order_history";
	}
	
}

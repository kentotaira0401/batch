package jp.co.rakus.ecommerce_b.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/showOrderHistory")
	public String shownotPaymentOrderHistory(Model model , @AuthenticationPrincipal LoginUser loginUser) {
		session.setAttribute("loginUser",loginUser);
		List<Order> orderList = showOrderHistoryService.showOrderhistory(loginUser);
		
		model.addAttribute("orderList",orderList);
		
		return "order_history";
		
	}
	
}

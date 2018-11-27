package jp.co.rakus.ecommerce_b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.form.OrderForm;
import jp.co.rakus.ecommerce_b.service.ShowCartItemService;

@Controller
@RequestMapping("/showCartItem")
public class ShowCartItemController {

	@Autowired
	private ShowCartItemService showCartItemService;
	
	@ModelAttribute
	public OrderForm SetUpForm() {
		return new OrderForm();
	}
	
	@RequestMapping("/showCart")
	public String showCart(Model model) {
		
		int userId = 3;
		int status = 0;
		List<Order> orderList = showCartItemService.findByUserIdAndStatus(userId, status);
		
		if(!(orderList.isEmpty())) {
		Order order = orderList.get(0);
		model.addAttribute("order",order);
		}
		
		return "cart_list";
		
	}
		
		
	
	
	
}

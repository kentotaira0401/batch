package jp.co.rakus.ecommerce_b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
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
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/showCart")
	public String showCart(Model model,@AuthenticationPrincipal LoginUser loginUser) {
		
		int userId = 0;
		int status = 0;
		
		if(loginUser == null){ //ユーザがログインしてなかった場合。
			  userId = session.getId().hashCode();
		}else {
			  userId = loginUser.getUser().getId();// ログインユーザid;
		}
		
		System.out.println("tmp"+userId);
		
		Order order = new Order();
	    order = showCartItemService.findByUserIdAndStatus(userId, status);
		
		model.addAttribute("order",order);

		return "cart_list";
	}
		
		
	
	
	
}

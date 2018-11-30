package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.service.DeleteCartItemService;


@Controller
@RequestMapping("/delete")
//FIXME:javadoc漏れ
public class DeleteCartItemController {

	@Autowired
	public DeleteCartItemService deletecartservice;
	
	@RequestMapping("/item")
	public String deleteCartItem(Integer orderItemId){
		
		System.out.println(orderItemId);
		deletecartservice.deleteByOrderItemId(orderItemId);
		
		return "redirect:/showCartItem/showCart";
	}
	
}

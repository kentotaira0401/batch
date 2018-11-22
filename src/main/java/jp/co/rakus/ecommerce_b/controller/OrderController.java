package jp.co.rakus.ecommerce_b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *　最終注文をするためのcontroller.
 * 
 * @author yuya.nishikiori
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	/**
	 * 注文画面を表示.
	 * 
	 * @return 注文確認画面にreturn.
	 */
	@RequestMapping("/order")
	public String order() {
		return "order_confirm";
	}
	
	
	
}

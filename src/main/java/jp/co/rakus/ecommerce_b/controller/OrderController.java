package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.form.OrderForm;
import jp.co.rakus.ecommerce_b.service.OrderService;

/**
 *　最終注文をするためのcontroller.
 * 
 * @author yuya.nishikiori
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	public OrderService service;
	
	@ModelAttribute
	public OrderForm SetUpForm() {
		return new OrderForm();
	}
	
	
	/**
	 * 注文画面を表示.
	 * 
	 * @return 注文確認画面にreturn.
	 */
	@RequestMapping("/order")
	public String order(@Validated OrderForm orderForm,BindingResult result,Model model) {
		Order order = service.findByUserIdAndStatus(); //未入金の order を使用
		model.addAttribute("order",order); //未入金の order を　confirm画面で使用
		return "order_confirm2";
	}
	
	/**
	 * 注文をDBに保存.
	 * 
	 * @return 注文完了画面にreturn.
	 */
	@RequestMapping("/orderConfirm")
	public String orderConfirm(Order order) {
	    service.save(order); // order情報をupdateする
		return "order_finished";
	}
	
}

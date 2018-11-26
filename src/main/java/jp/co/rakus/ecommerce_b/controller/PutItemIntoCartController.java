package jp.co.rakus.ecommerce_b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import jp.co.rakus.ecommerce_b.form.PutItemIntoCartForm;
import jp.co.rakus.ecommerce_b.service.PutItemIntoCartService;


@Controller
@RequestMapping("/putItemIntoCart")
public class PutItemIntoCartController {

	
	private PutItemIntoCartService putItemIntoCartService;
	
	@ModelAttribute
	public PutItemIntoCartForm setUpPutItemIntoForm() {
		return new PutItemIntoCartForm();
	}
	
	
	@RequestMapping("/putItem")
	public String putItemIntoCart(@Validated PutItemIntoCartForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "cart-list";
		}
		putItemIntoCartService.putItemIntoCart(form);
		return "cart-list";
	}
}
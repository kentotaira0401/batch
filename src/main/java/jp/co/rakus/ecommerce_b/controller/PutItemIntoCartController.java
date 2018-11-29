package jp.co.rakus.ecommerce_b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
import jp.co.rakus.ecommerce_b.form.PutItemIntoCartForm;
import jp.co.rakus.ecommerce_b.service.PutItemIntoCartService;


@Controller
@RequestMapping("/putItemIntoCart")
public class PutItemIntoCartController {

	@Autowired
	private PutItemIntoCartService putItemIntoCartService;
	
	@Autowired
	public HttpSession session;

	@RequestMapping("/putItem")
	public String putItemIntoCart(@Validated PutItemIntoCartForm form, BindingResult result, Model model,@AuthenticationPrincipal LoginUser loginUser) {
		session.setAttribute("loginUser",loginUser);
		if (result.hasErrors()) {
			return "";
		}
		putItemIntoCartService.putItemIntoCart(form,loginUser);
		return "redirect:/showCartItem/showCart";
	}
	
	
	
	
}

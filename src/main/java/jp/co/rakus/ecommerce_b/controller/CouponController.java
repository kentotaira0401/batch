package jp.co.rakus.ecommerce_b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.Coupon;
import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.repository.CouponRepository;

/**
 * クーポンを受け取るコントローラ.
 * 
 * @author yuya.nishikiori
 *
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	
	@Autowired 
	public HttpSession session;
	
	@Autowired
	public CouponRepository repository;
	
	@RequestMapping("/input")
	public String input(Integer couponId){
		
		Order order = null;
		order = (Order) session.getAttribute("order");
		
		// FIXME:無駄なインスタンス化 Coupon coupon = repository.findById(couponId);で良い
		Coupon coupon = new Coupon();
		coupon = repository.findById(couponId);
		Integer cuponPirce = coupon.getPrice();
		
		//注文のトータルから引く
		Integer TotalPrice = order.getCalcTotalPrice();
		
		//cuponを引いた金額を出す。
		int couponTotalPrice = order.getCalcCouponPirce(TotalPrice,coupon.getPrice());
		
		session.setAttribute("couponTotalPrice", couponTotalPrice);
		session.setAttribute("cuponPirce",cuponPirce);
		return "redirect:/order/order";
	}
	
	
}

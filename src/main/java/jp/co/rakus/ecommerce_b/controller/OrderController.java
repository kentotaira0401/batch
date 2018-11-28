package jp.co.rakus.ecommerce_b.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.form.OrderForm;
import jp.co.rakus.ecommerce_b.service.OrderService;
import jp.co.rakus.ecommerce_b.service.SendEmailServicec;

/**
 * 最終注文をするためのcontroller.
 * 
 * @author yuya.nishikiori
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	public OrderService service;

	@Autowired
	public SendEmailServicec emailservice;


	@ModelAttribute
	public OrderForm setUpForm() {
		return new OrderForm();
	}

	@Autowired
	public HttpSession session;
	

	/**
	 * 注文画面を表示.
	 * 
	 * @return 注文確認画面に
	 */

	@RequestMapping("/order")

	public String order(

			Model model, @AuthenticationPrincipal LoginUser loginUser) {

		Integer loginUserId = loginUser.getUser().getId();// ログインユーザid

		Integer paymentNumber = 0;// 未入金番号
		Order order = service.findByUserIdAndStatus(loginUserId, paymentNumber);

		model.addAttribute("order", order); // 未入金の order を confirm画面で使用

		return "order_confirm2";
	}

	/**
	 * 注文をDBに保存.
	 * 
	 * @return 注文完了画面にreturn.
	 * @throws ParseException
	 */
	@RequestMapping("/orderConfirm")

	public String orderConfirm(
			@Validated OrderForm form,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes,
			@AuthenticationPrincipal LoginUser loginUser) throws ParseException {

		if (result.hasErrors()) {
			return order(model,loginUser);
		}

		

		// formをコピー
		Order order = new Order();
		BeanUtils.copyProperties(form, order);


		// ** string を timestamp へ変換
		Timestamp deliverlyTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh")
				.parse(form.getDeliverlyDate() + " " + form.getDeliverlyTime()).getTime());

		// 注文した日付を取得
		Date todayDate = new Date();

		Integer loginUserId = loginUser.getUser().getId();// ログインユーザid
		Integer paymentNumber = 0;// 未入金番号

		Order notPaymentOrder = service.findByUserIdAndStatus(loginUserId, paymentNumber);
		order.setId(notPaymentOrder.getId());
		order.setUserId(notPaymentOrder.getUserId());
		order.setStatus(notPaymentOrder.getStatus());
		order.setTotalPrice(notPaymentOrder.getStatus());

		Integer paymentMethod = order.getPaymentMethod();

		if (paymentMethod == 1) {
			order.setStatus(1);
		} else {
			order.setStatus(2);
		}

		order.setOrderDate(todayDate);
		order.setDeliverlyTime(deliverlyTime);
		

		service.save(order); // order情報をupdateする
		emailservice.sendMail(order);
		return "order_finished";

	}

}

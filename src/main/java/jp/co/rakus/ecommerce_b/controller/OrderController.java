package jp.co.rakus.ecommerce_b.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.LoginUser;
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
	
	/**
	 * 注文画面を表示.
	 * 
	 * @return 注文確認画面に
	 */
	
	@RequestMapping("/order")
	public String order(Model model,@AuthenticationPrincipal LoginUser loginUser) {
		
		
		
		Integer loginUserId = loginUser.getUser().getId();//ログインユーザid
		System.out.println(loginUserId);
		Integer paymentNumber = 0;//未入金番号
		List<Order> orderList = (List<Order>) service.findByUserIdAndStatus(loginUserId,0);
		
		Order order = orderList.get(0);
		
		System.out.println("order"+order.toString());
		
		model.addAttribute("order",order); //未入金の order を　confirm画面で使用
		return "order_confirm2";
	}
	
	/**
	 * 注文をDBに保存.
	 * 
	 * @return 注文完了画面にreturn.
	 * @throws ParseException 
	 */
	@RequestMapping("/orderConfirm")
	public String orderConfirm(OrderForm form,Model model,@AuthenticationPrincipal LoginUser loginUser) throws ParseException {
	    
		 System.out.println("orderform"+form.toString());		
		
		 //formをコピー
		 Order order = new Order();
		 BeanUtils.copyProperties(form, order);
		 
		 //**  orderされた日付のstring を　date　へ変換する処理 **//
		 String date = form.getOrderDate();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date OrderDate = sdf.parse(date);
		
		 //** string を　timestamp へ変換
		 Timestamp deliverlyTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh").parse(form.getOrderDate()+ " " + form.getDeliverlyTime()).getTime() );
		 
		 //注文した日付を取得
		 Date todayDate = new Date();
		 
	     Integer loginUserId = loginUser.getUser().getId();//ログインユーザid
	     Integer paymentNumber = 0;//未入金番号
		 
		 List<Order> notPaymentOrderList = service.findByUserIdAndStatus(loginUserId,paymentNumber);
		 Order notPaymentOrder = notPaymentOrderList.get(0);
		 order.setId(notPaymentOrder.getId());
		 order.setUserId(notPaymentOrder.getUserId());
		 order.setStatus(notPaymentOrder.getStatus());
		 order.setTotalPrice(notPaymentOrder.getStatus());
		 
		 order.setOrderDate(todayDate);
		 order.setDeliverlyTime(deliverlyTime);
		 
		 service.save(order); // order情報をupdateする
		 return "order_finished";
	}
	
}

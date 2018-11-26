package jp.co.rakus.ecommerce_b.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String order(Model model) {
		List<Order> orderList = (List<Order>) service.findByUserIdAndStatus(); //未入金の order を使用
		
		System.out.println("orderList"+orderList.toString());
		
		for(Order order:orderList) {
			System.out.println("order"+order.toString());
		}
		
		model.addAttribute("orderList",orderList); //未入金の order を　confirm画面で使用
		return "order_confirm2";
	}
	
	/**
	 * 注文をDBに保存.
	 * 
	 * @return 注文完了画面にreturn.
	 * @throws ParseException 
	 */
	@RequestMapping("/orderConfirm")
	public String orderConfirm(OrderForm form,Model model) throws ParseException {
	    
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
		  
		 /*
		 Order notPaymentOrder = service.findByUserIdAndStatus();
		 order.setId(notPaymentOrder.getId());
		 order.setUserId(notPaymentOrder.getUserId());
		 order.setStatus(notPaymentOrder.getStatus());
		 order.setTotalPrice(notPaymentOrder.getStatus());
		 
		 order.setOrderDate(OrderDate);
		 order.setDeliverlyTime(deliverlyTime);
		 */
		 
		 System.out.println("order"+order.toString());
		 
		 service.save(order); // order情報をupdateする
		 return "order_finished";
	}
	
}

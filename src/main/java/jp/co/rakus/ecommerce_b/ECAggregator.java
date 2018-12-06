package jp.co.rakus.ecommerce_b;

import org.springframework.batch.item.file.transform.LineAggregator;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.User;

public class ECAggregator implements LineAggregator<Order> {

	@Override
	public String aggregate(Order order) {
		StringBuilder sb = new StringBuilder();
		//System.out.println(order.getId());
		sb.append(order.getId());
		sb.append(",");
		sb.append(order.getUserId());
		sb.append(",");
		sb.append(order.getStatus());
		sb.append(",");
		sb.append(order.getTotalPrice());
		User user = order.getUser();
		sb.append(user.getId());
		sb.append(",");
		sb.append(user.getName());
		sb.append(",");
		sb.append(user.getEmail());
		
		
		return sb.toString();
	}


	
	
}

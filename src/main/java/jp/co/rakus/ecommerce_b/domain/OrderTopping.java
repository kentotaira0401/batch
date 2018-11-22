package jp.co.rakus.ecommerce_b.domain;

/**
 * 注文トッピングを表すドメイン.
 * 
 * @author maiko
 *
 */
public class OrderTopping {
	
	/**id*/
	private int id;
	/**トッピングid*/
	private int toppingId;
	/**注文商品id*/
	private int orderItemId;
	/**トッピング*/
	private Topping topping;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getToppingId() {
		return toppingId;
	}
	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Topping getTopping() {
		return topping;
	}
	public void setTopping(Topping topping) {
		this.topping = topping;
	}

}

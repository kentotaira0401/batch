package jp.co.rakus.ecommerce_b.domain;

import java.util.List;

/**
 * 注文商品を表すドメイン.
 * 
 * @author maiko
 *
 */
public class OrderItem {

	/** id */
	private int id;
	/** 商品id */
	private int itemId;
	/** 注文id */
	private int orderId;
	/** 数量 */
	private int quantity;
	/** サイズ */
	private Character size;
	/** 商品 */
	private Item item;
	/** 注文トッピングリスト. */
	private List<Topping> orderToppingList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Character getSize() {
		return size;
	}

	public void setSize(Character size) {
		this.size = size;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Topping> getOrderToppingList() {
		return orderToppingList;
	}

	public void setOrderToppingList(List<Topping> orderToppingList) {
		this.orderToppingList = orderToppingList;
	}

}

package jp.co.rakus.ecommerce_b.form;

import java.util.List;

/**
 * 
 * 入力された商品の情報を格納するフォーム
 * 
 * @author wataru.saito
 *
 */
public class PutItemIntoForm {

	/**
	 * アイテムID
	 */
	private String itemId;
	/**
	 * ピザのサイズ
	 */
	private Character size;
	/**
	 * トッピング
	 */
	private List<String> toppingList;
	/**
	 * 数量
	 */
	private String quantity;

	public int getIntValueOfItemId() {
		return Integer.parseInt(this.itemId);
	}

	public int getIntValueOfQuantity() {
		return Integer.parseInt(this.quantity);
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Character getSize() {
		return size;
	}

	public void setSize(Character size) {
		this.size = size;
	}

	public List<String> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<String> toppingList) {
		this.toppingList = toppingList;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}

package jp.co.rakus.ecommerce_b.form;

import java.util.List;

/**
 * 
 * 入力された商品の情報を格納するフォーム
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
	private String size;
	/**
	 * トッピング
	 */
	private List<String> topping;
	/**
	 * 数量
	 */
	private String quantity;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<String> getTopping() {
		return topping;
	}

	public void setTopping(List<String> topping) {
		this.topping = topping;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}

package jp.co.rakus.ecommerce_b.domain;

import java.util.List;

/**
 * 商品を表すドメイン.
 * 
 * @author maiko
 *
 */
public class Item {

	/** id */
	private int id;
	/** 名前 */
	private String name;
	/** 説明 */
	private String description;
	/** Mサイズの価格 */
	private int priceM;
	/** Lサイズの価格 */
	private int priceL;
	/** 画像パス */
	private String imagePath;
	/** 削除フラグ */
	private Boolean deleted;
	/** トッピングリスト */
	private List<Topping> toppingList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriceM() {
		return priceM;
	}
	public void setPriceM(int priceM) {
		this.priceM = priceM;
	}
	public int getPriceL() {
		return priceL;
	}
	public void setPriceL(int priceL) {
		this.priceL = priceL;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public List<Topping> getToppingList() {
		return toppingList;
	}
	public void setToppingList(List<Topping> toppingList) {
		this.toppingList = toppingList;
	}
	
}

	
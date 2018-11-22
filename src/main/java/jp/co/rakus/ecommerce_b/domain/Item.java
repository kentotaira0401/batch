package jp.co.rakus.ecommerce_b.domain;

import java.util.List;

/**
 * 商品を表すドメイン.
 * 
 * @author maiko
 *
 */
public class Item {
	
	/**id*/
	private int id;
	/**名前*/
	private String naem;
	/**Mサイズの価格*/
	private int priceM;
	/**Lサイズの価格*/
	private int priceL;
	/**画像パス*/
	private String imagePath;
	/**削除フラグ*/
	private Boolean deleted;
	/**トッピングリスト*/
	private List<Topping> toppingList;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaem() {
		return naem;
	}
	public void setNaem(String naem) {
		this.naem = naem;
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

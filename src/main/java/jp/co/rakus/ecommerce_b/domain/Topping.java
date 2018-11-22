package jp.co.rakus.ecommerce_b.domain;

/**
 * トッピングを表すドメイン.
 * 
 * @author maiko
 *
 */
public class Topping {
	
	/**id*/
	private  int id;
	/**名前*/
	private String name;
	/**Mサイズの価格*/
	private int priceM;
	/**Ⅼサイズの価格*/
	private int priceL;
	
	
	/** getter/setter */
	
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

}

package jp.co.rakus.ecommerce_b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * orderを詰めるためのform.
 * 
 * @author yuya.nishikiori
 *
 */
public class OrderForm {

	/**
	 * 注文ID
	 */
	private Integer id;

	/**
	 * ユーザーID
	 */

	private Integer userId;

	/**
	 * 状態
	 */
	private Integer status;

	/**
	 * 合計金額
	 */
	private Integer totalPrice;

	/**
	 * 注文日
	 */
	private String orderDate;

	/**
	 * 宛先氏名
	 */
	@Email(message = "Eメールの形式が不正です")
	@NotBlank(message = "メールアドレスは必須です")
	private String destinationEmail;

	/**
	 * 宛先Email
	 */
	@NotBlank(message = "氏名は必須です")
	private String destinationName;

	/**
	 * 宛先郵便番号
	 */
	@NotBlank(message = "郵便番号は必須です")
	private String destinationZipcode;

	/**
	 * 宛先住所
	 */
	@NotBlank(message = "住所は必須です")
	private String destinationAddress;

	/**
	 * 宛先TEL
	 */
	@NotBlank(message = "電話番号は必須です")
	private String destinationTel;

	/**
	 * 配達時間
	 */

	private String deliverlyTime;

	/**
	 * 配達日
	 */
	@Pattern(regexp = "\\d{4}-\\d{1,2}-\\d{1,2}", message = "配送希望日を入力してください")
	private String deliverlyDate;

	/**
	 * 支払方法
	 */

	private Integer paymentMethod;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDestinationEmail() {
		return destinationEmail;
	}

	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationZipcode() {
		return destinationZipcode;
	}

	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationTel() {
		return destinationTel;
	}

	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}

	public String getDeliverlyTime() {
		return deliverlyTime;
	}

	public void setDeliverlyTime(String deliverlyTime) {
		this.deliverlyTime = deliverlyTime;
	}

	public String getDeliverlyDate() {
		return deliverlyDate;
	}

	public void setDeliverlyDate(String deliverlyDate) {
		this.deliverlyDate = deliverlyDate;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", userId=" + userId + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", destinationEmail=" + destinationEmail + ", destinationName="
				+ destinationName + ", destinationZipcode=" + destinationZipcode + ", destinationAddress="
				+ destinationAddress + ", destinationTel=" + destinationTel + ", deliverlyTime=" + deliverlyTime
				+ ", deliverlyDate=" + deliverlyDate + ", paymentMethod=" + paymentMethod + "]";
	}

}

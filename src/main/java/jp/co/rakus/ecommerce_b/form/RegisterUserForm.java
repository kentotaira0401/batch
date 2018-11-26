package jp.co.rakus.ecommerce_b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * ユーザー登録用Form
 * 
 * @author kento
 *
 */
public class RegisterUserForm {

	/** 名前 */
	@NotEmpty( message = "値を入力してください")
	private String name;
	/** Eメール */
	@NotEmpty( message = "値を入力してください")
	@Email( message = "メールアドレスの形式ではありません" )
	private String email;
	/** パスワード */
	@NotEmpty( message = "値を入力してください")
	private String password;
	/** 郵便番号*/
	@NotEmpty( message = "値を入力してください")
	private String zipcode;
	/** 住所*/
	@NotEmpty( message = "値を入力してください")
	private String address;
	/** 電話番号*/
	@NotEmpty( message = "値を入力してください")
	private String telephone;
	/**　確認用パスワード*/
	@NotEmpty( message = "値を入力してください")
	private String conformationPassword;
	
	public RegisterUserForm() {
		super();
	}
	public RegisterUserForm(String name, String email, String password, String zipcode, String address,
			String telephone, String conformationPassword) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.zipcode = zipcode;
		this.address = address;
		this.telephone = telephone;
		this.conformationPassword = conformationPassword;
	}
	@Override
	public String toString() {
		return "RegisterUserForm [name=" + name + ", email=" + email + ", password=" + password + ", zipcode=" + zipcode
				+ ", address=" + address + ", telephone=" + telephone + ", conformationPassword=" + conformationPassword
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getConformationPassword() {
		return conformationPassword;
	}
	public void setConformationPassword(String conformationPassword) {
		this.conformationPassword = conformationPassword;
	}
	
	
	
}

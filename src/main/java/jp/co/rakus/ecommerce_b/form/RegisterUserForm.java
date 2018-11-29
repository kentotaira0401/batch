package jp.co.rakus.ecommerce_b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * ユーザー登録用Form
 * 
 * @author kento
 *
 */
public class RegisterUserForm {

	/** 名前 */
	@NotEmpty( message = "名前を入力してください")
	private String name;
	/** Eメール */
	@NotEmpty( message = "メールアドレスを入力してください")
	@Email( message = "メールアドレスの形式ではありません" )
	private String email;
	/** パスワード */
	@NotEmpty( message = "パスワードを入力してください")
	@Size(min=8, max=16, message="パスワードは8文字以上16文字以内に設定してください")
	private String password;
	/** 郵便番号*/
	@NotEmpty( message = "郵便番号を入力してください")
	private String zipcode;
	/** 住所*/
	@NotEmpty( message = "住所を入力してください")
	private String address;
	/** 電話番号*/
	@NotEmpty( message = "電話番号を入力してください")
	@Pattern(regexp="[0-9]*", message="電話番号は数字で入力してください")
	private String telephone;
	/**　確認用パスワード*/
	@NotEmpty( message = "確認用パスワードを入力してください")
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

package jp.co.rakus.ecommerce_b.form;

/*import javax.validation.constraints.NotEmpty;
// FIXME:不要なコメントはpush時は削除しましょう
*//**
 * ログインフォーム
 * 
 * @author kento
 *
 *//*
public class LoginForm {

	*//** Eメール *//*
	@NotEmpty( message = "値を入力してください")
	private String email;
	*//** パスワード *//*
	@NotEmpty( message = "値を入力してください")
	private String password;
	
	public LoginForm() {
		super();
	}
	public LoginForm(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", password=" + password + "]";
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
	
	
	
}
*/
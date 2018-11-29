package jp.co.rakus.ecommerce_b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class RePasswordForm {

	/** Eメール */
	@NotEmpty( message = "メールアドレスを入力してください")
	@Email( message = "メールアドレスの形式ではありません" )
	private String email;
	
	
	public RePasswordForm() {
		super();
	}

	public RePasswordForm(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "RePasswordForm [email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

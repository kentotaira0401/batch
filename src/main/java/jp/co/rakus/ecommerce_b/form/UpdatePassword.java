package jp.co.rakus.ecommerce_b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UpdatePassword {


		/** Eメール */
		@NotEmpty( message = "メールアドレスを入力してください")
		@Email( message = "メールアドレスの形式ではありません" )
		private String email;

		/** パスワード */
		@NotEmpty( message = "パスワードを入力してください")
		@Size(min=8, max=16, message="パスワードは8文字以上16文字以内に設定してください")
		private String password;
		
		/**　確認用パスワード*/
		@NotEmpty( message = "確認用パスワードを入力してください")
		@Size(min=8, max=16, message="パスワードは8文字以上16文字以内に設定してください")
		private String conformationPassword;
		
		
	
		public UpdatePassword() {
			super();
		}




		public UpdatePassword(String email, String password, String conformationPassword) {
			super();
			this.email = email;
			this.password = password;
			this.conformationPassword = conformationPassword;
		}




		@Override
		public String toString() {
			return "RePasswordForm [email=" + email + "]";
		}

		
		

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConformationPassword() {
			return conformationPassword;
		}

		public void setConformationPassword(String conformationPassword) {
			this.conformationPassword = conformationPassword;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
	}

	


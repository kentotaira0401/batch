package jp.co.rakus.ecommerce_b.domain;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;　←下で

	/**
	 * 利用者のログイン情報を格納するエンティティ.
	 * 
	 * @author igamasayuki
	 *
	 */
	public class LoginUser extends org.springframework.security.core.userdetails.User{

		private static final long serialVersionUID = 1L;
		/** メンバー情報 */
		private final User user;
		/**
		 * 通常のメンバー情報に加え、認可用ロールを設定する。
		 * 
		 * @param Member　メンバー情報
		 * @param authorityList 権限情報が入ったリスト
		 */
		public LoginUser(User user, Collection<GrantedAuthority> authorityList) {
			super(user.getEmail(), user.getPassword(), authorityList);
			//System.out.println(user.getId());
			this.user = user;
		}

		public User getUser() {
			return user;
		}
	}



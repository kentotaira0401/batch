package jp.co.rakus.ecommerce_b.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.User;



@Repository
public class UserRepository {


	/**
	 * ResultSetオブジェクトからUserオブジェクトに変換するためのクラス実装&インスタンス化
	 */
	private static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String zipcode = rs.getString("zipcode");
		String address = rs.getString("address");
		String telephone = rs.getString("telephone");
		return new User(id, name, email, password, zipcode, address, telephone);
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	
	/*  メールアドレスとパスワードからユーザーを取得.
	  
	  @param mailAddress
	             メールアドレス
	  @param password
	             パスワード
	  @return ユーザー情報.ユーザーが存在しない場合はnull.
	 */
	public User findByMailAndPass(String email, String password) {
		User user = null;
		String sql = "SELECT id, name, email, password, zipcode, address, telephone FROM users WHERE email=:email AND password=:password;";

		try {
			
			SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);

			user = template.queryForObject(sql, param, USER_ROW_MAPPER);
			//System.out.println("a");
			return user;
			
		} catch (DataAccessException e) {
			//System.out.println("b");
			return null;
		}
	}

	/**
	 * 
	 * メールアドレスからユーザーを検索する
	 * 
	 * @param email
	 *            メールアドレス
	 * @return Userオブジェクト.該当するデータがなければnullを返す
	 */
	public User findByMailAddress(String email) {
		String sql = "SELECT id, name, email, password, zipcode, address, telephone FROM users WHERE email=:email";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
		
		//		try {
//			User User = jdbcTemplate.queryForObject(sql, param, User_ROW_MAPPER);
//
//			return User;
//		} catch (DataAccessException e) {
//			return null;
//		}
	}
	
	/**
	 * ユーザー情報を保存 または 更新する.
	 * 
	 * @param User
	 *            保存または更新するユーザー情報
	 * @return 保存または更新されたユーザー情報
	 */
	public User insert(User user) {
		String sql = "INSERT INTO users(name,email,password,zipcode,address,telephone) values(:name,:email,:password,:zipcode,:address,:telephone);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		
		//if (user.getId() == null) {
			template.update(sql,
							param);
		//} else {
		//	template.update(
		//			"UPDATE Users SET name=:name,mail_address=:mailAddress,password=:password WHERE id=:id", param);
		//}
		return user;
	}
	
}

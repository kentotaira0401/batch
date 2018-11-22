package jp.co.rakus.ecommerce_b.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.User;



@Repository
public class UserRepository {


	/**
	 * ResultSetオブジェクトからMemberオブジェクトに変換するためのクラス実装&インスタンス化
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

	
	/*  メールアドレスとパスワードからメンバーを取得.
	  
	  @param mailAddress
	             メールアドレス
	  @param password
	             パスワード
	  @return メンバー情報.メンバーが存在しない場合はnull.
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

	
}

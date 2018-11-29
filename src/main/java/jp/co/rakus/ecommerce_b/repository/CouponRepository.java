package jp.co.rakus.ecommerce_b.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Coupon;

@Repository
public class CouponRepository {
	
	private static final RowMapper<Coupon> couponRowMapper = (rs, i) -> {
		Coupon coupon = new Coupon();
		
		coupon.setId(rs.getInt("id"));
		coupon.setCouponId(rs.getInt("coupon_id"));
		coupon.setPrice(rs.getInt("price"));
		
		return coupon;
	};
	
	
	@Autowired
	public NamedParameterJdbcTemplate template;
	

	/**
	 * Couponを検索.
	 * 
	 * @param id
	 * @return item
	 */
	public Coupon findById(Integer couponId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("coupon_id",couponId);
		String sql = "SELECT id,coupon_id,price FROM coupon WHERE coupon_id=:coupon_id;";
		Coupon coupon = template.queryForObject(sql, param, couponRowMapper);
		return coupon;
	}


	
}

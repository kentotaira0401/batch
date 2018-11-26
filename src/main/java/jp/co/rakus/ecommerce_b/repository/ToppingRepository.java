package jp.co.rakus.ecommerce_b.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.domain.Topping;

@Repository
public class ToppingRepository {
	
	private final RowMapper<Topping> TOPPING_ROWMAPPER = (rs, i) -> {
	Topping topping = new Topping();
	
	topping.setId(rs.getInt("id"));
	topping.setName(rs.getString("name"));
	topping.setPriceM(rs.getInt("price_m"));
	topping.setPriceL(rs.getInt("price_l"));
		return topping;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Topping> findAll(){
		
		String sql="SELECT id,name,price_m,price_l FROM toppings;";
		List<Topping> toppingList = template.query(sql, TOPPING_ROWMAPPER);
		return toppingList;
	}
	

}

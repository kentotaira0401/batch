package jp.co.rakus.ecommerce_b.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Item;

@Repository
public class ItemRepository {

	private static final RowMapper<Item> itemRowMapper = (rs, i) -> {
		Item item = new Item();

		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPriceM(rs.getInt("price_m"));
		item.setPriceL(rs.getInt("price_l"));
		item.setImagePath(rs.getString("image_path"));
		item.setDeleted(rs.getBoolean("deleted"));

		return item;

	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 商品一覧を取得する.
	 * 
	 * @return itemList
	 */
	public List<Item> findAll() {

		String sql = "SELECT id,name,description,price_m,price_l,image_path,deleted FROM items;";

		List<Item> itemList = template.query(sql, itemRowMapper);
		return itemList;

	}

	/**
	 * 商品名の曖昧検索をする.
	 * 
	 * @param name
	 *            商品名
	 * @return
	 */
	public List<Item> findByName(String name) {

		String sql = "SELECT id,name,description,price_m,price_l,image_path,deleted FROM items WHERE name like :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
		List<Item> itemlist = template.query(sql, param, itemRowMapper);

		return itemlist;

	}
	/**
	 * 詳細表示.
	 * 
	 * @param id
	 * @return item
	 */
	public Item findById(int id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		String sql = "SELECT id,name,description,price_m,price_l,image_path,deleted FROM items WHERE id=:id;";
		Item item = template.queryForObject(sql, param, itemRowMapper);
		return item;
	}

}

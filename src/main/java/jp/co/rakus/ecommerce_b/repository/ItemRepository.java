package jp.co.rakus.ecommerce_b.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.domain.OrderItem;

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
	
	private static final RowMapper<Item> popularItemRowMapper = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("ordI_item_id"));
		item.setName(rs.getString("i_name"));
		item.setImagePath(rs.getString("i_imagePath"));
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

	public List<Item> findbyOrdernum() {
		String sql = "select ordI.item_id ordI_item_id ,i.name i_name , i.image_path i_imagePath ,count(ordI.item_id) from orders as ord inner join order_Items as ordI on ord.id = ordI.order_id inner \r\n" + 
				"join items as i on ordI.item_id = i.id group by ordI.item_id ,i.name ,i.image_path order by count(ordI.item_id) desc  OFFSET 0 LIMIT 3;";
		List<Item> itemList = template.query(sql,popularItemRowMapper);
		return itemList;
	}
}

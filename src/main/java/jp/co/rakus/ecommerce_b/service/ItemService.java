package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.repository.ItemRepository;

@Service
//FIXME:javadoc漏れ
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * テーブルに登録されている全ての商品情報を返す.
	 * 
	 * @return List<Item> 商品一覧を表示
	 */
	public List<Item> findAll() {
		return itemRepository.findAll();	
	}
	
	/**
	 * 商品名の曖昧検索をする.
	 * 
	 * @param name　商品名
	 * @return 検索された商品一覧を表示
	 */
	public List<Item> findByName(String name) {
		return itemRepository.findByName(name);
	}
	
	/**
	 * 商品の詳細を表示する.
	 * 
	 * @param id
	 * @return Item
	 */
	public Item findById(int id) {
		return itemRepository.findById(id);
		
	}

}

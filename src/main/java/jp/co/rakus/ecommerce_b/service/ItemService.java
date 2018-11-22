package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.repository.ItemRepository;

@Service
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
	

}

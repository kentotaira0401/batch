package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.repository.ItemRepository;

@Service
public class PopularItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findByOrderNum() {

		List<Item> list = itemRepository.findbyOrdernum();
		return list;

	}
}

package jp.co.rakus.ecommerce_b.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jp.co.rakus.ecommerce_b.domain.Topping;

import jp.co.rakus.ecommerce_b.repository.ToppingRepository;

@Service
//FIXME:javadoc漏れ
public class FindAllToppingService {
	
	@Autowired
	private ToppingRepository toppingRepository;

	/**
	 * トッピング一覧を取得する.
	 * 
	 * @return List<Topping> トッピング一覧
	 */
	public Map<Integer,String> findAll() {
		List<Topping> toppingList =  toppingRepository.findAll();
		Map<Integer, String> toppingMap = new LinkedHashMap<>();
		for (Topping topping : toppingList) {
			toppingMap.put(topping.getId(), topping.getName());
		}
		
		
		
		return toppingMap;	
	}
	
}

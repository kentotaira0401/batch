package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jp.co.rakus.ecommerce_b.domain.Topping;

import jp.co.rakus.ecommerce_b.repository.ToppingRepository;

@Service
public class FindAllToppingService {
	
	@Autowired
	private ToppingRepository toppingRepository;

	/**
	 * トッピング一覧を取得する.
	 * 
	 * @return List<Topping> トッピング一覧
	 */
	public List<Topping> findAll() {
		return toppingRepository.findAll();	
	}
	
}

package jp.co.rakus.ecommerce_b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.service.ItemService;

@Controller
@RequestMapping("/SerchItem")
public class SerchItemController {

	@Autowired
	ItemService itemService;

	/**
	 * 商品一覧を表示
	 * 
	 * @param model
	 *            モデル
	 * @return 商品リスト
	 */
	@RequestMapping("/Serch")
	public String Serch(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);
		return "item-list";
	}

	@RequestMapping("/FuzzySerch")
	public String FuzzySerch(Model model, String name) {
		List<Item> itemList = itemService.findByName(name);
		model.addAttribute("itemList", itemList);
		
		return "item-list";

	}
	@RequestMapping("/detailItem")
	public String detailItem(int id,Model model) {
		Item item = itemService.findById(id);
		model.addAttribute("item",item);
		return "item-detail";
	}

}

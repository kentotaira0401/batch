package jp.co.rakus.ecommerce_b.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.domain.LoginUser;
import jp.co.rakus.ecommerce_b.form.PutItemIntoCartForm;
import jp.co.rakus.ecommerce_b.service.FindAllToppingService;
import jp.co.rakus.ecommerce_b.service.ItemService;

@Controller
@RequestMapping("/SearchItem")
public class SearchItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private FindAllToppingService findAllToppingService;

	@ModelAttribute
	public PutItemIntoCartForm setUpPutItemIntoCartForm() {
		return new PutItemIntoCartForm();
	}

	/**
	 * 商品一覧を表示
	 * 
	 * @param model
	 *            モデル
	 * 
	 * @return 商品リスト
	 */
	@RequestMapping("/Search")
	public String Search(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);
		return "item-list";
	}

	/**
	 * 検索結果を表示
	 * 
	 * @param model
	 * @param name
	 *            商品名
	 * @return 検索された商品リスト（リストが空の場合は全てのアイテムを表示）
	 */
	@RequestMapping("/FuzzySearch")
	public String FuzzySerch(Model model, String name) {
		List<Item> itemList = itemService.findByName(name);

		//System.out.println("1111");
		if ((itemList.size() == 0) || (name == "")) {
			itemList = itemService.findAll();
			boolean isEmpty = true;
			model.addAttribute("isEmpty", isEmpty);
			System.out.println("テストisEmpty呼ばれた");
		}

		model.addAttribute("itemList", itemList);

		return "item-list";

	}

	/**
	 * 
	 * 商品詳細画面を表示.
	 * 
	 * @param id
	 * @param model
	 *            モデル
	 * @return 商品詳細画面
	 */
	@RequestMapping("/detailItem")
	public String detailItem(int id, Model model,@AuthenticationPrincipal LoginUser loginUser) {
		//System.out.println(loginUser.getUser().getId());
		Item item = itemService.findById(id);
		model.addAttribute("item", item);
		Map<Integer, String> toppingMap = findAllToppingService.findAll();
		model.addAttribute("toppingMap", toppingMap);
		return "item-detail";
	}

}

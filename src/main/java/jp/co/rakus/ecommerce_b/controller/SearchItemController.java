
package jp.co.rakus.ecommerce_b.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;//

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
import jp.co.rakus.ecommerce_b.service.OrderService;
import jp.co.rakus.ecommerce_b.service.PopularItemService;

@Controller
@RequestMapping("/SearchItem")
//FIXME:javadoc漏れ
public class SearchItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private FindAllToppingService findAllToppingService;

	@Autowired
	private PopularItemService popularItemService;
	
	@ModelAttribute
	public PutItemIntoCartForm setUpPutItemIntoCartForm() {
		return new PutItemIntoCartForm();
	}
	@Autowired
	public OrderService service;//
	
	@Autowired
	public HttpSession session;//
	
	
	/*
	 * 商品一覧を表示
	 * 
	 * @param model
	 *            モデル
	 * 
	 * @return 商品リスト
	 */
	@RequestMapping("/Search")
	public String Search(Model model,@AuthenticationPrincipal LoginUser loginUser) {
	 
		
		session.setAttribute("loginUser",loginUser);
		
		if(loginUser != null) {
			Integer userId = loginUser.getUser().getId();
			session.setAttribute("userId",userId);
			
			Integer tmpId = (Integer) session.getAttribute("tmpId");	
			service.updateUserId(userId, tmpId);
		}
		
		List<Item> itemList = itemService.findAll();
		List<Item> popularItemList = popularItemService.findByOrderNum();
		model.addAttribute("itemList", itemList);
		model.addAttribute("popularItemList", popularItemList);
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
	public String FuzzySerch(Model model, String name,@AuthenticationPrincipal LoginUser loginUser) {
		List<Item> itemList = itemService.findByName(name);
		
		session.setAttribute("loginUser",loginUser);

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
		session.setAttribute("loginUser",loginUser);
		Item item = itemService.findById(id);
		model.addAttribute("item", item);
		Map<Integer, String> toppingMap = findAllToppingService.findAll();
		model.addAttribute("toppingMap", toppingMap);
		return "item-detail";
	}

}




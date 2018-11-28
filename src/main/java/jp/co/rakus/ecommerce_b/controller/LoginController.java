package jp.co.rakus.ecommerce_b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * ログイン処理をするコントローラー
 * 
 * @author kento
 *
 */
@Controller
@Transactional
@RequestMapping("/")
public class LoginController {

	//※ログイン認証フィルターが機能するためいらなくなりました。
	/*@Autowired
	private LoginService userService;
	
	@Autowired
	private RegisterUserInfoService registerService;
	*/
	//※ログイン認証フィルターが機能するためいらなくなりました。
	/**
	 * フォームを初期化します.
	 * 
	 * @return フォーム
	 */
	/*@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}
*/
	/**
	 * ログイン画面を表示します.
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("/")
	public String index(Model model/*
									 * LoginForm form, BindingResult resultz*/, @RequestParam(required = false) String
									  error
									 ) {
		
		  System.err.println("login error:" + error); if (error != null) {
		  System.err.println("User: login failed"); 
		  //result.addError(new ObjectError("loginError", "メールアドレスまたはパスワードが不正です。"));
		  model.addAttribute("loginError", "メールアドレスまたはパスワードが不正です。"); }
		 System.out.println("2222");
		return "login";
	}

	/**
	 * ログイン後検索画面を表示します
	 * 
	 * @param model
	 * @return ログイン後検索画面
	 */
	@RequestMapping("/item-list")
	public String itemList(Model model) {
		return "item-list";
	}

	//※ログイン認証フィルターが機能し、item-list.jspに遷移するようにしたためいらなくなりました。
	/**
	 * ログアウト画面を表示します
	 * 
	 * @return ログアウト画面
	 */
/*	@RequestMapping("/logout2")
	public String logout(Model model) {
		System.out.println("111");
		return "logout";
	}*/
	
	//※ログイン認証フィルターが機能するためいらなくなりました。
	/**
	 * ログイン処理を行います.
	 * 
	 * @param form
	 *            フォーム
	 * @param result
	 *            リザルト
	 * @param model
	 *            モデル
	 * @return ログイン成功時：書籍リスト画面
	 */
	/*//@RequestMapping("/login")
	public String login(@Validated LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		String email = form.getEmail();
		String rawPass = form.getPassword();

		// メールアドレスから個人を特定し、失敗したらログイン画面に返す
		User user = registerService.findByEmail(email);
		if (user == null) {
			ObjectError error = new ObjectError("loginerror", "メールアドレスが違います。");
			result.addError(error);
			System.out.println("失敗(mail)");
			return index(model);
		}
		System.out.println(user);
		// ハッシュ化されたパスワード
		String encryptPass = user.getPassword();
		// ハッシュ化されたパスワードと入力されたパスワードが合わなければログイン画面に戻す
		Boolean isMatch = registerService.isMatchPassword(rawPass,encryptPass);
		if (!isMatch) {
			ObjectError error = new ObjectError("loginerror", "パスワードが違います。");
			result.addError(error);
			System.out.println("失敗(pass)");
			return index(model);
		}
		
		 * User user = userService.findOneByMailAndPass(email, password); if (user ==
		 * null) { ObjectError error = new ObjectError("loginerror",
		 * "メールアドレスまたはパスワードが違います。"); result.addError(error); System.out.println("失敗");
		 * return index(model); }
		 
		model.addAttribute("user", user);
		System.out.println("成功");

		return "redirect:/item-list";
	}
*/
}

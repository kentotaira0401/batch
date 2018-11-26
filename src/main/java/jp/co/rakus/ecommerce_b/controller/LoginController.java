package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.form.LoginForm;
import jp.co.rakus.ecommerce_b.service.LoginService;
import jp.co.rakus.ecommerce_b.service.RegisterUserInfoService;

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

	@Autowired
	private LoginService userService;
	
	@Autowired
	private RegisterUserInfoService registerService;
	
	// ※ログインフィルターが機能するためいらなくなる予定？？
	/**
	 * フォームを初期化します.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	/**
	 * ログイン画面を表示します.
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("/")
	public String index(Model model/*
									 * LoginForm form, BindingResult result, @RequestParam(required = false) String
									 * error
									 */) {
		/*
		 * System.err.println("login error:" + error); if (error != null) {
		 * System.err.println("User: login failed"); //result.addError(new
		 * ObjectError("loginError", "メールアドレスまたはパスワードが不正です。"));
		 * model.addAttribute("loginError", "メールアドレスまたはパスワードが不正です。"); }
		 */
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
	@RequestMapping("/login")
	public String login(@Validated LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		String email = form.getEmail();
		String rawPass = form.getPassword();

		// メールアドレスから個人を特定し、失敗したらログイン画面に返す
		User user = registerService.findByMailAddress(email);
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
		/*
		 * User user = userService.findOneByMailAndPass(email, password); if (user ==
		 * null) { ObjectError error = new ObjectError("loginerror",
		 * "メールアドレスまたはパスワードが違います。"); result.addError(error); System.out.println("失敗");
		 * return index(model); }
		 */
		model.addAttribute("user", user);
		System.out.println("成功");

		return "redirect:/item-list";
	}

}

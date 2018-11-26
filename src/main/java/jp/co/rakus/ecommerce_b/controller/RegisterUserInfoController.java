package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.form.RegisterUserForm;
import jp.co.rakus.ecommerce_b.service.RegisterUserInfoService;

@Controller
@Transactional
@RequestMapping("/register")
public class RegisterUserInfoController {

	@Autowired
	private RegisterUserInfoService registerService;
	
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public RegisterUserForm setUpForm() {
		return new RegisterUserForm();
	}
	
	/**
	 * ユーザー登録画面を表示します.
	 * 
	 * @param model
	 * @return ユーザー登録画面
	 */
	@RequestMapping("/registerForm")
	public String toRegisterUser(Model model) {
		System.out.println("a");
		return "register_user";
	}
	
	
	/**
	 * メンバー情報を登録します.
	 * @param form フォーム
	 * @param result リザルト
	 * @param model モデル
	 * @return ログイン画面
	 */
	@RequestMapping("/create")
	public String create(@Validated RegisterUserForm form,
							BindingResult result,
							Model model) {

		// パスワード確認
		if(!form.getPassword().equals(form.getConformationPassword())){
			result.rejectValue("conformationPassword", "", "パスワードを確認してください");
		}

		// メールアドレスが重複している場合の処理
		User valUser = registerService.findByMailAddress(form.getEmail());
		if(valUser != null){
			result.rejectValue("email", "", "すでにメールアドレスが登録されています");
		}
		if(result.hasErrors()){
			return toRegisterUser(model);
		}

		// パスワードを暗号化し、formに設定
		form.setPassword(registerService.encodePassword(form.getPassword()));
		
		// フォームの内容をエンティティに格納
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user = registerService.insert(user);
		System.out.println(user);
		System.out.println("成功");
		
		return "redirect:/";
	}
	
	
	
}

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
import jp.co.rakus.ecommerce_b.form.RePasswordForm;
import jp.co.rakus.ecommerce_b.form.RegisterUserForm;
import jp.co.rakus.ecommerce_b.form.UpdatePassword;
import jp.co.rakus.ecommerce_b.service.RegisterUserInfoService;
import jp.co.rakus.ecommerce_b.service.SendEmailServicec;

@Controller
@Transactional
@RequestMapping("/register")
//FIXME:javadoc漏れ
public class RegisterUserInfoController {

	@Autowired
	private RegisterUserInfoService registerService;
	
	@Autowired
	private SendEmailServicec sendEmailService;
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public RegisterUserForm setUpForm() {
		return new RegisterUserForm();
	}
	
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public RePasswordForm setUpRePassForm() {
		return new RePasswordForm();
	}
	
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public UpdatePassword setUpUpdateForm() {
		return new UpdatePassword();
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
	 * パスワード忘れ、URL送信用の
	 * メールアドレスを送るフォーム画面を表示します.
	 * 
	 * @param model
	 * @return メールアドレスを送るフォーム画面
	 */
	@RequestMapping("/rePasswordForm")
	public String toRePassword(Model model) {
		return "re_password";
	}
	
	/**
	 * パスワード忘れ、URL送信用の
	 * メールアドレスを送るフォーム画面を表示します.
	 * 
	 * @param model
	 * @return メールアドレスを送るフォーム画面
	 */
	@RequestMapping("/toFinisheMail")
	public String toFinishedMail(Model model) {
		return "finished_send_mail";
	}
	
	/**
	 * パスワード忘れ、URL送信用の
	 * メールアドレスを送るフォーム画面を表示します.
	 * 
	 * @param model
	 * @return メールアドレスを送るフォーム画面
	 */
	@RequestMapping("/toFinishedUpdate")
	public String toFinishedUpdate(Model model) {
		return "finished_update_password";
	}
	
	/**
	 * パスワード忘れ、URL送信用の
	 * メールアドレスを送るフォーム画面を表示します.
	 * 
	 * @param model
	 * @return メールアドレスを送るフォーム画面
	 */
	@RequestMapping("/toUpdatePass")
	public String toUpdatePass(Model model) {
		return "update_password";
	}
	
	/**
	 * ユーザー情報を登録します.
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
		User valUser = registerService.findByEmail(form.getEmail());
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
		// FIXME:デバッグ用のsysoutはpush時は削除しましょう
		System.out.println(user);
		System.out.println("成功");
		
		return "redirect:/";
	}
	
	/**
	 * メンバー情報を登録します.
	 * @param form フォーム
	 * @param result リザルト
	 * @param model モデル
	 * @return ログイン画面
	 */
	@RequestMapping("/rePass")
	public String reCreate(@Validated RePasswordForm form,
							BindingResult result,
							Model model) {

		if(result.hasErrors()){
			System.out.println("やっちまったいら");
			return toRePassword(model);
		}
		// メールアドレスが登録されていない場合の処理
		User valUser2 = registerService.findByEmail(form.getEmail());
		if(valUser2 == null){
			result.rejectValue("email", "", "そのメールアドレスは登録されていません");
			return toRePassword(model);
		}
		

		System.out.println(valUser2);
		
		// メールアドレスが登録されていればそのメールアドレスにメールを送信
		sendEmailService.sendMailForRePass(valUser2.getEmail());
		System.out.println("オッケー平");
		return "redirect:/register/toFinisheMail";
	}
	
	/**
	 * ユーザー情報を登録します.
	 * @param form フォーム
	 * @param result リザルト
	 * @param model モデル
	 * @return ログイン画面
	 */
	@RequestMapping("/updatePass")
	public String updatePass(@Validated UpdatePassword form,
							BindingResult result,
							Model model) {

		// パスワード確認
		if(!form.getPassword().equals(form.getConformationPassword())){
			result.rejectValue("conformationPassword", "", "パスワードを確認してください");
		}

		// メールアドレスが重複している場合の処理
		User valUser = registerService.findByEmail(form.getEmail());
		if(valUser == null){
			result.rejectValue("email", "", "登録されていないパスワードです");
		}
		if(result.hasErrors()){
			return toRegisterUser(model);
		}

		// パスワードを暗号化し、formに設定
		form.setPassword(registerService.encodePassword(form.getPassword()));
		
		// フォームの内容をエンティティに格納
		User user = new User();
		BeanUtils.copyProperties(form, user);
		registerService.update(user.getEmail(),user.getPassword());
		System.out.println(user);
	
		
		return "redirect:/register/toFinishedUpdate";
	}
	
}

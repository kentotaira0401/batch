package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.repository.UserRepository;
//FIXME:インポート文に警告あり。警告は０を目指しましょう
@Service
//FIXME:javadoc漏れ
public class RegisterUserInfoService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// FIXME:不要なコメントはpush時は削除しましょう
	//↓SecurityConfig.javaにてすでに設定済み
	/*@Bean  
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	// public List<Member> findAll(){
	// return memberRepository.findAll();
	// }
	//
	// public Member findOne(Integer id) {
	// return memberRepository.findOne(id);
	// }

	// /**
	// * メールアドレスとパスワードに該当するもの見つける.
	// *
	// * @param mailAddress
	// * メールアドレス
	// * @param password
	// * パスワード
	// * @return Memberエンティティを返す. 該当するものがなければnullを返す
	// */
	// public Member findOneByMailAddressAndPassword(String mailAddress, String
	// password) {
	// Member member = memberRepository.findByMailAddress(mailAddress);
	//
	// // メールアドレスが登録されていない場合
	// if (member == null) {
	// return null;
	// }
	//
	// if (!isMatchPassword(password, member.getPassword())) {
	// return null;
	// }
	// return member;
	// }

	/**
	 * 入力された登録情報を保存する.
	 * 
	 * @param user
	 *            入力された登録情報
	 * @return
	 */
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	/**
	 * 入力されたパスワードを更新する.
	 * 
	 * @param user
	 *            入力された登録情報
	 * @return
	 */
	public void update(String email, String rePassword) {
		 userRepository.update(email, rePassword);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/**
	 * 暗号化する.
	 * 
	 * @param rawPassword
	 *            暗号化前のパスワード(元のパスワード)
	 * @return 暗号化後のパスワード
	 */
	public String encodePassword(String rawPassword) {
		String encodedPassword = passwordEncoder.encode(rawPassword);
		return encodedPassword;
	}

	// /**
	// * 入力したパスワードがDBにあるパスワードと一致するかどうか.
	// *
	// * @param rowPassword
	// * 入力されたパスワード
	// * @param encodedPassword
	// * DB上にある暗号化されたパスワード
	// * @return 正しければtrue
	// */
	public boolean isMatchPassword(String rowPassword, String encodedPassword) {
		return passwordEncoder.matches(rowPassword, encodedPassword);
	}

	/*
	 * public void delete(Integer id){ memberRepository.delete(id); }
	 */

}

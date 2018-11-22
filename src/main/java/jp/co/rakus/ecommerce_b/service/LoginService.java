package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public User findOneByMailAndPass(String email, String password) {
		
		User user =userRepository.findByMailAndPass(email, password);
		
		return user;
	}
}

package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Coupon;
import jp.co.rakus.ecommerce_b.repository.CouponRepository;

@Service
public class CouponService {
		
	@Autowired
	public CouponRepository repository;
	
	public Coupon findById(Integer coupon_id) {
		return repository.findById(coupon_id);
	}
}

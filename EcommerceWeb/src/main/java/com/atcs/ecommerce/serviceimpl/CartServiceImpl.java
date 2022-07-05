package com.atcs.ecommerce.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.atcs.ecommerce.entity.Cart;
import com.atcs.ecommerce.repo.CartRepo;
import com.atcs.ecommerce.service.CartService;

@Component
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepo cartRepo;
	
	@Override
	public List<Cart> getData() {
		
		return cartRepo.findAll();
	}
	@Override
	public Cart getDataById(int id) {
		
		return cartRepo.findById(id).get();
	}

	@Override
	public ResponseEntity<String> postData(Cart cart) {
		cart.setCreatedDate(new Date());
		if(cart.getQuantity()>5 && cart.getQuantity()<1){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		cartRepo.save(cart);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<String> putData(Cart cart) {
		if(cart.getQuantity()>5){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		cartRepo.save(cart);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

	@Override
	public void deleteData(int id) {
		cartRepo.deleteById(id);
		
	}

}

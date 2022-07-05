package com.atcs.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atcs.ecommerce.entity.Cart;


@Service
public interface CartService {
	
	public List<Cart> getData();

	public ResponseEntity<String> postData(Cart car);

	public ResponseEntity<String> putData(Cart car);

	public void deleteData(int id);

	public Cart getDataById(int id);

}

package com.atcs.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atcs.ecommerce.service.CheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	CheckoutService checkoutService;
	
	
	@PostMapping("/{id}")
	public void postCheck(@PathVariable("id") int id  )
	{
		checkoutService.postCheck(id);
	}
}
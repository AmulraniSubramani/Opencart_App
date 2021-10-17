package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	
	private By cartpage=By.id("cart"); // raindom value
	
	public CartPage() {
		System.out.println("this is cart page");
	}
	
	public void addToCart() {
		System.out.println("Add to cart");
		
		System.out.println("Added actions");
	}
	
	
}

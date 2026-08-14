package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	private By cartBtn=By.id("cart");

	public CartPage() {
		System.out.println("Cart page........");
	}
	public void addToCart() {
		System.out.println("Add to cart...");
		System.out.println("Add feature is done...");
	}
}

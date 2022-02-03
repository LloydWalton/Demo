package com.qa.demo.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.demo.testbase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement productTitle;

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement logo;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement sortFilter;

	@FindBy(className = "shopping_cart_link")
	WebElement cartLink;

	@FindBy(xpath = "//span[contains(text(),'Your Cart')]")
	WebElement carttitle;

	@FindBy(xpath = "//div[@class='cart_quantity']")
	WebElement cartQty;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement cartPrice;

	@FindAll({ @FindBy(xpath = "//div[@class='inventory_item_price']") })
	List<WebElement> prices;

	Double maxValue;

	public HomePage() {
		PageFactory.initElements(driver, this);  // to initialize page factory web elements 
	}

	public String verifyHomePageTitle1() { // Verify homepage title
		return driver.getTitle();

	}

	public boolean verifyHomepagefields() { //Verify homepage fields
		return productTitle.isDisplayed() & logo.isDisplayed() & sortFilter.isDisplayed();

	}

	public void selectHighProd() throws InterruptedException { // Selecting high price product

		List<Double> prodValue = new ArrayList<>();
		for (int i = 0; i < prices.size(); i++) {
			Double val = Double.parseDouble(prices.get(i).getText().replace("$", ""));
			prodValue.add(val);
		}

		maxValue = Collections.max(prodValue); // Identifying max value
		int index = prodValue.indexOf(maxValue);
		System.out.println(index);
		index = index + 1;
		driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[" + index + "]"))
				.click();

	}

	public boolean verifyCartpage() throws InterruptedException { //Navigating to cartpage
		cartLink.click();
		return carttitle.isDisplayed();

	}

	public boolean verifyCartsummary() { // Validating cart summary

		return cartQty.getText().contentEquals("1") & cartPrice.getText().contentEquals("$" + maxValue);

	}

}

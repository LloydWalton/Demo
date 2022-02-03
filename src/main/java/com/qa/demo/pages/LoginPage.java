package com.qa.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.demo.testbase.TestBase;

public class LoginPage extends TestBase {

	// Page Factory
	@FindBy(name = "user-name")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this); // to initialize page factory web elements
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(); // Returning to homepage (Page Linking)

	}

}

package com.qa.demo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.pages.HomePage;
import com.qa.demo.pages.LoginPage;
import com.qa.demo.testbase.TestBase;
import com.qa.demo.util.Util;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Util util;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void login() throws InterruptedException {  //Login 
		initialization();
		util = new Util();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Login is returning to
																								// homepage

	}

	

	@Test(priority = 1)
	public void verifyHomePageTitleTest() throws InterruptedException { // HomePage title validation
		Assert.assertEquals(homePage.verifyHomePageTitle1(), "Swag Labs");
		
	}

	@Test(priority = 2)
	public void verifyHomepagefields() throws InterruptedException { // HomePage fields validation
		Assert.assertTrue(homePage.verifyHomepagefields());
		
	}

	@Test(priority = 3)
	public void selectHighProd() throws InterruptedException { // Identifying highest value product
		homePage.selectHighProd();
		homePage.verifyCartpage();
		Assert.assertTrue(homePage.verifyCartpage());
		Assert.assertTrue(homePage.verifyCartsummary());

		
	}

	@AfterMethod
	public void tearDown() { // Closing browser
		driver.quit();
	}
}

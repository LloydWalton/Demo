// Added Comment
package com.qa.demo.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.pages.HomePage;
import com.qa.demo.pages.LoginPage;
import com.qa.demo.testbase.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;

	HomePage homepage; // Page linking purpose

	public LoginPageTest() {
		super(); // to initialize prop file
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage(); // to call login page methods
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException { // login
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

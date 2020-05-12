package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePageAfterSignIn;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{    //every class will be child of TestBase class 
	
	LoginPage loginPage;		//to use loginPage object reference through out programe
	HomePageAfterSignIn homePage1;	//created homePage1 reference variable for HomePageAfterSignIn class
	
	public LoginPageTest() {		//constructor of LoginPageTest class
		super();	
	/*
	 * it will call super class constructor i.e. TestBase by using super keyword
	 * so it will initialize properties i.e it will link with .properties
	 */
	}

	@BeforeMethod
	public void setUP() {
		initialization();	//it will call initialization() method from TestBase class to launch browser 
	
		 loginPage = new LoginPage();	//created object reference of class from com.crm.qa.pages class to access all objects from class
		
	}
	
	/*@Test(priority = 1)
	public void loginPageTitleTest() {		
		String title = loginPage.validateLoginPageTitle();		//validateLoginPageTitle() created as action in LoginPage class
		Assert.assertEquals(title, "Cogmento CRM", "Title is wrong. Please check title==>");	//validaion
	}
	
	@Test(priority = 2)
	public void submitButtonEnableTest() {		 
		boolean loginButton = loginPage.validateLoginBtn();   //validateLoginBtn() created as action in LoginPage class
		Assert.assertTrue(loginButton, "Login Button not enabled==>");
	}*/
	
	@Test(priority = 3)
	public void loginTest() {
		homePage1 = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password")); 
		//validateLogin(mailId, pwd) created as action in LoginPage class
	/*stored homePage1 class object. HomePage1 is reference of HomePageAfterSignIn class 
	 * and validateLogin is returning object of HomePageAfterSignIn class*/
	}

	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePageAfterSignIn;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{		//every class will be child of TestBase class 
	
	LoginPage loginPage;
	HomePageAfterSignIn homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {		//constructor of HomePageTest class
		super();	
	/*
	 * it will call super class constructor i.e. TestBase by using super keyword
	 * so it will initialize properties i.e it will link with .properties
	 */
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();	//it will call initialization() method from TestBase class to launch browser 
		contactsPage = new ContactsPage(); 	//reference oject for ContactsPage class
		dealsPage = new DealsPage();		//reference oject for DealsPage class
		loginPage = new LoginPage();	//created object reference of class from com.crm.qa.pages class to access all objects from class 
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyTitleOfHomePageTest() {
		String homePageTitle = homePage.verifyHomePageTitle();	//validate verifyHomePageTitle() created as action in HomePageAfterSignIn class
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title is wrong. Please check==>");
		System.out.println("BalleBalle");
	}
	
	@Test(priority = 2)
	public void verifyCorrectUserNameTest() {
		boolean nameOfUser = homePage.verifyCorrectUserName();
		Assert.assertTrue(nameOfUser);
		System.out.println("yoyo");
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
		System.out.println("Babo");
		
	}
	
	
	@Test(priority = 4)
	public void verifyDealsLinkTest() {
		System.out.println("bar hay ka daji");
	dealsPage = homePage.clickOnDealsLink();
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Bye");
		driver.quit();
	}
	

}

/*
author is Shantnu Bharswadkar
*/

package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePageAfterSignIn;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePageAfterSignIn homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	String sheetName ="contacts";
	public ContactsPageTest() {		//constructor of HomePageTest class
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
	
	@DataProvider
	public Object[][] createCRMContacts() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "createCRMContacts")
	public void createNewContactFromExcelTestData(String firstName, String lastName, String company) {
		homePage.clickOnContactsLink();
		//contactsPage.createNewContacts("ABC", "PQR", "XYZ");
		contactsPage.createNewContacts(firstName, lastName, company);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Bye");
		driver.quit();
	}
	
}

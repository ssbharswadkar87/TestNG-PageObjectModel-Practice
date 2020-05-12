package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePageAfterSignIn extends TestBase {
	
	/* we have to define object repository (page factory) where we will 
	define all web elements which we have to test and which are available on this page */
	
	//We are using @FindBy annotation in the place of driver.findElement
	@FindBy(xpath="//span[contains(text(),'Shantnu Bharswadkar')]")
	//@CacheLookup
	// @CacheLookup is annotation which saves userNameLabel value in cache memory.
	//so instead of taking value from page, it will take value from cache so speed of framework or script will increase 
	//but if anytime page get refreshed then this cache metomy will get corrupt so if it is confirm that page will not
	//get change then only use this annotation
	static WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts') and @class='item-text']")
	static WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals') and @class='item-text']")
	static WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks') and @class='item-text']")
	static WebElement tasksLink;
	
	//initializing page object
		public HomePageAfterSignIn() {			//Constructor of Loogin Page
			//PageFactory.initElements(driver, pageClassToProxy) to initialize page factory with driver and available elements
			PageFactory.initElements(driver, this);
		//this means current class object which we have defined like userNameLabel, contactsLink, dealsLink, tasksLink
		}
		
		
	//Actions
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}
		
		public ContactsPage clickOnContactsLink() {
			contactsLink.click();
			return new ContactsPage();
		}

		public DealsPage clickOnDealsLink() {
			dealsLink.click();
			return new DealsPage();
		}

		public ContactsPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}
		
}

package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	/* we have to define object repository (page factory) where we will 
	define all web elements which we have to test and which are available on this page */
	
	//We are using @FindBy annotation in the place of driver.findElement
	@FindBy(xpath="//th[contains(text(),'Email')]")
	static WebElement contactsEmailLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactBtn;
	
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement companyName;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveButton;
	
	//initializing page object
			public ContactsPage() {			//Constructor of Loogin Page
				//PageFactory.initElements(driver, pageClassToProxy) to initialize page factory with driver and available elements
				PageFactory.initElements(driver, this);
			//this means current class object which we have defined like userNameLabel, contactsLink, dealsLink, tasksLink
			}
	
			
			//Actions
			public boolean verifyCotactsTab() {
				return contactsEmailLabel.isDisplayed();
			}
			
			public void createNewContacts(String fstName, String lstName, String comp) {
				
				newContactBtn.click();
				driver.navigate().refresh();
				driver.navigate().refresh();
				firstName.sendKeys(fstName);
				lastName.sendKeys(lstName);
				companyName.sendKeys(comp,Keys.ARROW_DOWN, Keys.ENTER);
				saveButton.click();
				
			}
			
}

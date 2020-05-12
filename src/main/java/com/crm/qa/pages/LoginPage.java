package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	/* we have to define object repository (page factory) where we will 
	define all web elements which we have to test and which are available on this page */
	
	//We are using @FindBy annotation in the place of driver.findElement
	@FindBy(xpath="//input[@name='email']")
	static WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	static	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login') and @class='ui fluid large blue submit button']")
	static	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	//initializing page object
	public LoginPage() {			//Constructor of Loogin Page
		//PageFactory.initElements(driver, pageClassToProxy) to initialize page factory with driver and available elements
		PageFactory.initElements(driver, this);
	//this means current class object which we have defined like email, password,login button, signUp
	}
	
	
	//Actions
	public static String validateLoginPageTitle() {
		System.out.println("Hi");
		return driver.getTitle();
	}
	
	public static boolean validateLoginBtn() {
		System.out.println("Hi");
		return loginButton.isEnabled();
	}
	
	public static HomePageAfterSignIn validateLogin(String mailId, String pwd) {
		email.clear();
		email.sendKeys(mailId);
		
		password.clear();
		password.sendKeys(pwd);
		
		loginButton.click();
		
 //after clicking on login button we will navigate to home page which is our next class 
		return new HomePageAfterSignIn();
	}
	
}
	
	
	
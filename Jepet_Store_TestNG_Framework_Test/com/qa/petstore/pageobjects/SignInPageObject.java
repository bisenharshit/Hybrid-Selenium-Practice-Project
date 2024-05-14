package com.qa.petstore.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.petstore.test.PetStoreTest;

public class SignInPageObject {

	WebDriver driver;
    Logger log = Logger.getLogger(SignInPageObject.class.getName());	

	@FindBy(css = "[name='username']")
	WebElement username;
	
	@FindBy(css = "[name='password']")
	WebElement password;
	
	@FindBy(css = "div[class='button-bar'] button[class='button']")
	WebElement button;
	
	public SignInPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn_Method(String username1, String password1) throws InterruptedException {
		log.info("*********************!!SignIn!!Class!!Starts!!********************");
		Thread.sleep(500);
		JavaScriptPageObjectForScroll j =new JavaScriptPageObjectForScroll(driver);
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		username.clear();
		Thread.sleep(200);
		username.sendKeys(username1);
		password.clear();
		Thread.sleep(200);
		password.sendKeys(password1);
		Thread.sleep(500);
		button.click();
		log.info("*********************!!SignIn!!Class!!Ends!!********************");
	}
}

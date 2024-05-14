package com.qa.petstore.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignOutPageObject {

	WebDriver driver;
	Logger  log = Logger.getLogger(SignOutPageObject.class.getName());
	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signout;
	
	public SignOutPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignOut_Method() throws InterruptedException {
		log.info("*********************!!SignOut!!Class!!Starts!!********************");
		JavaScriptPageObjectForScroll j = new JavaScriptPageObjectForScroll(driver);
		Thread.sleep(500);
		j.javaScriptScrollMethod(0, 300);
		Thread.sleep(500);
		// Sign out the website
		signout.click();
		// Close the browser
		Thread.sleep(500);
		j.javaScriptScrollMethod(0, 300);
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Closing Page Title : "+driver.getTitle());
		System.out.println("Closing Page Current URL : "+driver.getCurrentUrl());
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		log.info("*********************!!SignOut!!Class!!Ends!!********************");
	}
	
}

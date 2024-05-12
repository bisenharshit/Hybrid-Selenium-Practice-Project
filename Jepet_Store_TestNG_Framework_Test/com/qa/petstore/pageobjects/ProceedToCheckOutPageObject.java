package com.qa.petstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProceedToCheckOutPageObject {

	WebDriver driver;
	
	@FindBy(css = "[name='cardType']")
	WebElement cardType;
	
	@FindBy(css = "[name='creditCard']")
	WebElement creditCard;
	
	@FindBy(css = "[name='expiryDate']")
	WebElement expiryDate;
	
	@FindBy(css = "[name='shippingAddressRequired']")
	WebElement shippingAddressRequired;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement Continue;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement Continue1;
    
	public ProceedToCheckOutPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Proceed_To_Checkout_Method() throws InterruptedException {
		JavaScriptPageObjectForScroll j = new JavaScriptPageObjectForScroll(driver);
		Thread.sleep(500);
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		// Payment Details
	    Select select = new Select(cardType);
	    select.selectByValue("MasterCard");
	    Thread.sleep(200);
	    creditCard.clear();
	    Thread.sleep(500);
	    creditCard.sendKeys("25645849878825");
	    Thread.sleep(200);
	    expiryDate.clear();
	    Thread.sleep(500);
	    expiryDate.sendKeys("12/2025");
	    Thread.sleep(500);
	    j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		// Billing Address all details fill automatically but  only check the box and click button
		shippingAddressRequired.click();
		Continue.click();
	    // To cancel the page click on below web-element
	    // driver.findElement(By.xpath("//button[text()='Cancel']")).click();
	    // Shipping Address Details Confirmation Click
	    Thread.sleep(500);
	    Continue1.click();
	    // To go back from the page please click below webelement
	    // driver.findElement(By.xpath("//button[text()='Back']")).click();	
	    
	}
}

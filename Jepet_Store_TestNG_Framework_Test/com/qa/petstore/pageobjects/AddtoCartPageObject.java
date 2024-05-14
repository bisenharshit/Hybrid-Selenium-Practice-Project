package com.qa.petstore.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.petstore.test.PetStoreTest;

public class AddtoCartPageObject {

	WebDriver driver;
	Logger log = Logger.getLogger(AddtoCartPageObject.class.getName());	
	@FindBy(xpath = "//div[@id='SidebarContent']/a[3]")
	WebElement SidebarContent;
	
	@FindBy(css = "#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(1) > a")
	WebElement itemsselection;
	
	@FindBy(xpath = "//a[@href='/cart/addItemToCart?itemId=EST-14']")
	WebElement addItemToCart;
	
	@FindBy(xpath = "//a[text()='Proceed to Checkout']")
	WebElement ProceedtoCheckout;
	
	public AddtoCartPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddToCart_Method() throws InterruptedException {
		log.info("*********************!!Add_To_Cart!!Class!!Starts!!********************");
		JavaScriptPageObjectForScroll j = new JavaScriptPageObjectForScroll(driver);
		Thread.sleep(500);		
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		SidebarContent.click();
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		itemsselection.click();
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		addItemToCart.click();
		j.javaScriptScrollMethod(0, 400);
		Thread.sleep(200);
		// If you want to update the cart the prefer the below option
		//driver.findElement(By.xpath("//button[text()='Update Cart']")).click();
		Thread.sleep(500);
		ProceedtoCheckout.click();
		log.info("*********************!!Add_To_Cart!!Class!!Ends!!********************");
		
	}
}

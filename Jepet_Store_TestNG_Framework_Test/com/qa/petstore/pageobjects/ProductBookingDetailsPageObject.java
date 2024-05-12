package com.qa.petstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductBookingDetailsPageObject {

	WebDriver driver;
	
	
	@FindBy(xpath = "//*[@id='CenterForm']/form/table[1]/tbody/tr")
	WebElement orderno;
	
	@FindBy(xpath = "//*[@id='CenterForm']/form/table[2]/tbody")
	WebElement billing;
	
	@FindBy(xpath = "//*[@id='CenterForm']/form/table[3]/tbody")
	WebElement shipping;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement Confirm;
	
	public ProductBookingDetailsPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void Product_Booking_Details_Method() throws InterruptedException {
		JavaScriptPageObjectForScroll j = new JavaScriptPageObjectForScroll(driver);
		Thread.sleep(500);
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		// To Capture the Order Number
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******Order Number********");
		String orderno1 = orderno.getText();
		System.out.println(orderno1+" ");
		System.out.println();
		// To Capture Complete Billing Address
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******Billing Address********");
		String billing1 = billing.getText();
		System.out.println(billing1+" ");
		System.out.println();
		// To Capture Complete Shipping Address
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******Shipping Address********");
		String shipping1 = shipping.getText();
		System.out.println(shipping1+" ");
		System.out.println();
		Confirm.click();
	}
}

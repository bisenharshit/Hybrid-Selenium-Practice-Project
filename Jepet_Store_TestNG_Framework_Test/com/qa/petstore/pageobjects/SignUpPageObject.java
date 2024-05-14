package com.qa.petstore.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPageObject {

	WebDriver driver;
    Logger log = Logger.getLogger(SignUpPageObject.class.getName());
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement Signup;

	@FindBy(css = "[name='username']")
	WebElement username;

	@FindBy(css = "[name='password']")
	WebElement password;

	@FindBy(css = "[name='repeatedPassword']")
	WebElement rpassword;

	@FindBy(css = "[name='firstName']")
	WebElement firstName;

	@FindBy(css = "[name='lastName']")
	WebElement lastName;

	@FindBy(css = "[name='email']")
	WebElement email;

	@FindBy(css = "[name='phone']")
	WebElement phone;

	@FindBy(css = "[name='address1']")
	WebElement address1;

	@FindBy(css = "[name='address2']")
	WebElement address2;

	@FindBy(css = "[name='city']")
	WebElement city;

	@FindBy(css = "[name='state']")
	WebElement state;

	@FindBy(css = "[name='zip']")
	WebElement zip;

	@FindBy(css = "[name='country']")
	WebElement country;

	@FindBy(css = "[name='languagePreference']")
	WebElement languagePreference;

	@FindBy(css = "[name='favouriteCategoryId']")
	WebElement favouriteCategoryId;

	@FindBy(css = "[name='listOption']")
	WebElement listOption;

	@FindBy(css = "[name='bannerOption']")
	WebElement bannerOption;

	@FindBy(css = "div[class='button-bar'] button[class='button']")
	WebElement button;

	public SignUpPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SignUp_Method(String un, String ps, String rps,String fn, String ln, String em, String phn, String adr1, String adr2, String cty, String st, String zp, String con) throws InterruptedException {
        log.info("*********************!!SignUp!!Class!!Starts!!********************");
		Signup.click();
		JavaScriptPageObjectForScroll j = new JavaScriptPageObjectForScroll(driver);
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		// User Information
		username.sendKeys(un);
		password.sendKeys(ps);
		rpassword.sendKeys(rps);
		// Account Information
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(em);
		phone.sendKeys(phn);
		Thread.sleep(200);
		j.javaScriptScrollMethod(0, 635);
		Thread.sleep(200);
		address1.sendKeys(adr1);
		address2.sendKeys(adr2);
		city.sendKeys(cty);
		state.sendKeys(st);
		zip.sendKeys(zp);
		country.sendKeys(con);
		// Profile Information
		Select select = new Select(languagePreference);
		select.selectByValue("german");
		Select select1 = new Select(favouriteCategoryId);
		select1.selectByValue("CATS");
		listOption.click();
		bannerOption.click();
		Thread.sleep(200);
		button.click();
		log.info("*********************!!SignUp!!Class!!Ends!!********************");
	}
}

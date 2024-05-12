package com.qa.petstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPageObject {

	WebDriver driver;

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

	public void SignUp_Method(String username1, String password1) throws InterruptedException {

		Signup.click();
		JavaScriptPageObjectForScroll j = new JavaScriptPageObjectForScroll(driver);
		j.javaScriptScrollMethod(0, 350);
		Thread.sleep(200);
		// User Information
		username.sendKeys(username1);
		password.sendKeys(password1);
		rpassword.sendKeys(password1);
		// Account Information
		firstName.sendKeys("Jhon");
		lastName.sendKeys("Watson");
		email.sendKeys("jhonwatson@gmail.com");
		phone.sendKeys("9254789561");
		Thread.sleep(200);
		j.javaScriptScrollMethod(0, 635);
		Thread.sleep(200);
		address1.sendKeys("Rowden Street");
		address2.sendKeys("Khau Gali");
		city.sendKeys("Kolkata");
		state.sendKeys("West Bengal");
		zip.sendKeys("411022");
		country.sendKeys("India");
		// Profile Information
		Select select = new Select(languagePreference);
		select.selectByValue("german");
		Select select1 = new Select(favouriteCategoryId);
		select1.selectByValue("CATS");
		listOption.click();
		bannerOption.click();
		Thread.sleep(200);
		button.click();

	}
}

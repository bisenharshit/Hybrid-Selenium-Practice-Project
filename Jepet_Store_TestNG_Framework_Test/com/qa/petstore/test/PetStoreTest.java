package com.qa.petstore.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.petstore.commonutility.BasicPetStoreUtility;
import com.qa.petstore.pageobjects.AddtoCartPageObject;
import com.qa.petstore.pageobjects.JavaScriptPageObjectForScroll;
import com.qa.petstore.pageobjects.ProceedToCheckOutPageObject;
import com.qa.petstore.pageobjects.ProductBookingDetailsPageObject;
import com.qa.petstore.pageobjects.SignInPageObject;
import com.qa.petstore.pageobjects.SignOutPageObject;
import com.qa.petstore.pageobjects.SignUpPageObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetStoreTest{

	public WebDriver driver;
	public JavaScriptPageObjectForScroll j;
	public String username = "johnwatson169";
	public String password = "Jhon@123";
    
	
	
	@BeforeSuite
	public void basicConfigSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
	}
	
	

	@BeforeTest
	public void windowUrlSetupWithExtentReporter() {
		driver.get("https://jpetstore.aspectran.com");

	}
	
	@BeforeClass
	public void windowSizeSetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void cookiesGettingSetup() {
		Set<Cookie> cook = driver.manage().getCookies();
		for (Cookie c : cook) {
			System.out.println("Cookie Domain : " + c.getDomain());
			System.out.println("Cookie Name : " + c.getName());
			System.out.println("Cookie Expiry : " + c.getExpiry());
			System.out.println("!!!!!***************!!!!!!");
		}

	}
	@Test(priority = 1)
	public void testCase_1_Landing_On_HomePage_with_Scroll() throws InterruptedException {
		j = new JavaScriptPageObjectForScroll(driver);
		j.javaScriptScrollMethod(0, 350);

	}

	@Test(priority = 2)
	public void testcase_2_SignUp_On_Website() throws InterruptedException {
		SignUpPageObject sup = new SignUpPageObject(driver);
		sup.SignUp_Method(username, password);

	}

	@Test(priority = 3)
	public void testcase_3_SignIn_On_Website() throws InterruptedException {
		SignInPageObject sin = new SignInPageObject(driver);
		sin.SignIn_Method(username, password);

	}

	@Test(priority = 4)
	public void testcase_4_AddToCart_On_Website() throws InterruptedException {
		AddtoCartPageObject atc = new AddtoCartPageObject(driver);
		atc.AddToCart_Method();

	}

	@Test(priority = 5)
	public void testcase_5_Proceed_To_Checkout_On_Website() throws InterruptedException {
		ProceedToCheckOutPageObject ptc = new ProceedToCheckOutPageObject(driver);
		ptc.Proceed_To_Checkout_Method();

	}

	@Test(priority = 6)
	public void testcase_6_Product_Booking_Details_On_Website() throws InterruptedException {
		ProductBookingDetailsPageObject pbdp = new ProductBookingDetailsPageObject(driver);
		pbdp.Product_Booking_Details_Method();

	}

	@Test(priority = 7)
	public void testcase_7_SignOut_On_Website() throws InterruptedException {
		SignOutPageObject so = new SignOutPageObject(driver);
		so.SignOut_Method();

	}
	
	@AfterClass
	public void cookies_Deleting_Setup() {
		System.out.println("Successfully Delete All Cookies");
	}

	@AfterTest
	public void project_Database_Config_setup() {
		System.out.println("Data Base Configurations Here");
	}

	@AfterSuite
	public void closing_All_The_Resources() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("All Resources Successfully Closed");
		driver.close();
	}

}

//public void jPetStore_Project_Complete_Demo() throws InterruptedException {

package com.qa.petstore.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;
import com.qa.petstore.Json.Mapper.JSON_Data_Mapper;
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
	public String username;
	public String password;
    Logger log = Logger.getLogger(PetStoreTest.class.getName());	
	
	@BeforeSuite
	public void basicConfigSetup() {
		log.info("*****Basic_Config_Method_Starts_Successfully*****");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		log.info("*****Basic_Config_Method_Ends_Successfully*****");
	}
	
	

	@BeforeTest
	public void windowUrlSetupWithExtentReporter() {
		log.info("*****Window_URL_SetUp_With_Extent_Reporter_Method_Starts_Successfully*****");
		driver.get("https://jpetstore.aspectran.com");
		log.info("*****Window_URL_SetUp_With_Extent_Reporter_Method_Ends_Successfully*****");

	}
	
	@BeforeClass
	public void windowSizeSetup() {
		log.info("*****Window_Size_And_Wait_SetUp_Method_Starts_Successfully*****");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("*****Window_Size_And_Wait_SetUp_Method_Ends_Successfully*****");
	}

	@BeforeMethod
	public void cookiesGettingSetup() {
		log.info("*****Cookies_Getting_SetUp_Method_Starts_Successfully*****");
		Set<Cookie> cook = driver.manage().getCookies();
		for (Cookie c : cook) {
			System.out.println("Cookie Domain : " + c.getDomain());
			System.out.println("Cookie Name : " + c.getName());
			System.out.println("Cookie Expiry : " + c.getExpiry());
			System.out.println("!!!!!***************!!!!!!");
			log.info("*****Cookies_Getting_SetUp_Method_Ends_Successfully*****");
		}

	}
	@Test(priority = 1)
	public void testCase_1_Landing_On_HomePage_with_Scroll() throws InterruptedException {
		log.info("*****TestCase_1_Landing_On_HomePage_with_Scroll_Method_Starts_Successfully*****");
		j = new JavaScriptPageObjectForScroll(driver);
		j.javaScriptScrollMethod(0, 350);
		log.info("*****TestCase_1_Landing_On_HomePage_with_Scroll_Method_Ends_Successfully*****");
	}

	 // Data Pass By JSON File
	@Test(priority = 2, dataProvider = "getData")
	public void testcase_2_SignUp_On_Website(Map<String, String> input) throws InterruptedException {
		log.info("*****Testcase_2_SignUp_On_Website_Method_Starts_Successfully*****");
		SignUpPageObject sup = new SignUpPageObject(driver);
		username =input.get("uname"); password = input.get("pass");
		sup.SignUp_Method(username, password,input.get("rpass"),input.get("fname"),input.get("lname"),input.get("email"),input.get("phone"),input.get("addr1"),input.get("addr2"),input.get("city"),input.get("state"),input.get("zip"), input.get("country"));
		log.info("*****Testcase_2_SignUp_On_Website_Method_Ends_Successfully*****");
	}

	
	@Test(priority = 3)
	public void testcase_3_SignIn_On_Website() throws InterruptedException {
		log.info("*****Testcase_3_SignIn_On_Website_Method_Starts_Successfully*****");
		//Assert.assertEquals(driver.getCurrentUrl(), "https://jpetstore.aspectran.com/account/signonForm"); 
		// Data Pass same by JSON file only
		SignInPageObject sin = new SignInPageObject(driver);
		sin.SignIn_Method(username, password);
		log.info("*****Testcase_3_SignIn_On_Website_Method_Ends_Successfully*****");
	}

	@Test(priority = 4)
	public void testcase_4_AddToCart_On_Website() throws InterruptedException {
		log.info("*****Testcase_4_AddToCart_On_Website_Method_Starts_Successfully*****");
		AddtoCartPageObject atc = new AddtoCartPageObject(driver);
		atc.AddToCart_Method();
		log.info("*****Testcase_4_AddToCart_On_Website_Method_Ends_Successfully*****");
	}

	@Test(priority = 5)
	public void testcase_5_Proceed_To_Checkout_On_Website() throws InterruptedException, IOException {
		log.info("*****Testcase_5_Proceed_To_Checkout_On_Website_Method_Starts_Successfully*****");
		//Data send by the property files
		ProceedToCheckOutPageObject ptc = new ProceedToCheckOutPageObject(driver);
		ptc.Proceed_To_Checkout_Method();
		log.info("*****Testcase_5_Proceed_To_Checkout_On_Website_Method_Ends_Successfully*****");
	}

	@Test(priority = 6)
	public void testcase_6_Product_Booking_Details_On_Website() throws InterruptedException {
		log.info("*****Testcase_6_Product_Booking_Details_On_Website_Method_Starts_Successfully*****");
		ProductBookingDetailsPageObject pbdp = new ProductBookingDetailsPageObject(driver);
		pbdp.Product_Booking_Details_Method();
		log.info("*****Testcase_6_Product_Booking_Details_On_Website_Method_Ends_Successfully*****");
	}

	@Test(priority = 7)
	public void testcase_7_SignOut_On_Website() throws InterruptedException {
		log.info("*****Testcase_7_SignOut_On_Website_Method_Starts_Successfully*****");
		SignOutPageObject so = new SignOutPageObject(driver);
		so.SignOut_Method();
		log.info("*****Testcase_7_SignOut_On_Website_Method_Ends_Successfully*****");
	}
	

	@AfterSuite
	public void tearDown() throws InterruptedException {
		log.info("*****Tear_Down_Method_Starts_Successfully*****");
		Thread.sleep(3000);
		System.out.println("All Resources Successfully Closed");
		driver.close();
		log.info("*****Tear_Down_Method_Ends_Successfully*****");
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = JSON_Data_Mapper.getJsonDataToMap();
		//For Data Driver with different sets of data
//		return new Object[][] { { data.get(0) }, { data.get(1) } };
		
		//For single set of data
		return new Object[][] { { data.get(0) } };
		
	}

}

// Logger file content

/*log4j.rootLogger=DEBUG,cons,file
log4j.appender.cons=org.apache.log4j.ConsoleAppender
log4j.appender.cons.layout=org.apache.log4j.PatternLayout
log4j.appender.cons.layout.ConversionPattern=%p\t%d{ISO8601}\t%r\t%c\t[%t]\t%m%n

# add a FileAppender to the logger fout
log4j.appender.file=org.apache.log4j.FileAppender
# create a log file
log4j.appender.file.File=src//test//resources//Log4j Text File//DWSHybridDriven.txt
log4j.appender.file.layout=org.apache.log4j.PatternLayout
# use a more detailed message pattern
log4j.appender.file.layout.ConversionPattern=%p\t%d{ISO8601}\t%r\t%c\t[%t]\t%m%n
*/





















//public void jPetStore_Project_Complete_Demo() throws InterruptedException {

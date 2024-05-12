package JpetStore_Complete_Automation_Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetStoreTest {

	WebDriver driver;
	JavascriptExecutor js;
	String username = "johnwatson137";
	String password = "Jhon@123";
	@BeforeSuite
	public void basicConfigSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver();
		
	}
	
	@BeforeTest
	public void windowUrlSetup()
	{
		driver.get("https://jpetstore.aspectran.com/");
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
	       for(Cookie c :cook) {
	    	   System.out.println("Cookie Domain : "+c.getDomain());
	    	   System.out.println("Cookie Name : "+c.getName());
	    	   System.out.println("Cookie Expiry : "+c.getExpiry());
	    	   System.out.println("!!!!!***************!!!!!!");
	       }
		
	}
	
	@Test
	public void testCase_1_Landing_On_HomePage() {
		js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,300)");
	}
	
	@Test
	public void testcase_2_SignUp_On_Website() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		//User Information
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='repeatedPassword']")).sendKeys(password);
		// Account Information
		driver.findElement(By.cssSelector("[name='firstName']")).sendKeys("Jhon");
		driver.findElement(By.cssSelector("[name='lastName']")).sendKeys("Watson");
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("jhonwatson@gmail.com");
		driver.findElement(By.cssSelector("[name='phone']")).sendKeys("9254789561");
		Thread.sleep(200);
		js.executeScript("scrollBy(0,635)");
		Thread.sleep(200);
		driver.findElement(By.cssSelector("[name='address1']")).sendKeys("Rowden Street");
		driver.findElement(By.cssSelector("[name='address2']")).sendKeys("Khau Gali");
		driver.findElement(By.cssSelector("[name='city']")).sendKeys("Kolkata");
		driver.findElement(By.cssSelector("[name='state']")).sendKeys("West Bengal");
		driver.findElement(By.cssSelector("[name='zip']")).sendKeys("411022");
		driver.findElement(By.cssSelector("[name='country']")).sendKeys("India");
        // Profile Information
	 	WebElement langpref = driver.findElement(By.cssSelector("[name='languagePreference']"));
        Select select = new Select(langpref);
        select.selectByValue("german");
        WebElement favcate = driver.findElement(By.cssSelector("[name='favouriteCategoryId']"));
        Select select1 = new Select(favcate);
        select1.selectByValue("CATS");
        driver.findElement(By.cssSelector("[name='listOption']")).click();
        driver.findElement(By.cssSelector("[name='bannerOption']")).click();
        Thread.sleep(200);
        driver.findElement(By.cssSelector("div[class='button-bar'] button[class='button']")).click();

	}
	
	
	@Test
	public void testcase_3_SignIn_On_Website() throws InterruptedException {
		Thread.sleep(500);
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		WebElement un = driver.findElement(By.cssSelector("[name='username']"));
		un.clear();
		Thread.sleep(200);
		un.sendKeys(username);
		WebElement ps = driver.findElement(By.cssSelector("[name='password']"));
		ps.clear();
		Thread.sleep(200);
		ps.sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("div[class='button-bar'] button[class='button']")).click();
	
	}
	
	
	
	@Test
	public void testcase_4_AddToCart_On_Website() throws InterruptedException {
		Thread.sleep(500);
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@id='SidebarContent']/a[3]")).click();
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(1) > a")).click();
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		driver.findElement(By.xpath("//a[@href='/cart/addItemToCart?itemId=EST-14']")).click();
		js.executeScript("scrollBy(0,400)");
		Thread.sleep(200);
		// If you want to update the cart the prefer the below option
		//driver.findElement(By.xpath("//button[text()='Update Cart']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='Proceed to Checkout']")).click();
		
	}
	
	
	
	@Test
	public void testcase_5_Proceed_To_Checkout_On_Website() throws InterruptedException {
	
		Thread.sleep(500);
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		// Payment Details
		WebElement pcard  = driver.findElement(By.cssSelector("[name='cardType']"));
	    Select select = new Select(pcard);
	    select.selectByValue("MasterCard");
	    WebElement credit = driver.findElement(By.cssSelector("[name='creditCard']"));
	    Thread.sleep(200);
	    credit.clear();
	    Thread.sleep(500);
	    credit.sendKeys("25645849878825");
	    WebElement expiry = driver.findElement(By.cssSelector("[name='expiryDate']"));
	    Thread.sleep(200);
	    expiry.clear();
	    Thread.sleep(500);
	    expiry.sendKeys("12/2025");
	    Thread.sleep(500);
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		// Billing Address all details fill automatically but  only check the box and click button
		driver.findElement(By.cssSelector("[name='shippingAddressRequired']")).click();
	    driver.findElement(By.xpath("//button[text()='Continue']")).click();
	    // To cancel the page click on below web-element
	    // driver.findElement(By.xpath("//button[text()='Cancel']")).click();
	    // Shipping Address Details Confirmation Click
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//button[text()='Continue']")).click();
	    // To go back from the page please click below webelement
	    // driver.findElement(By.xpath("//button[text()='Back']")).click();	
	    
	}
	
	
	@Test
	public void testcase_6_Product_Booking_Details_On_Website() throws InterruptedException {
	
		Thread.sleep(500);
		js.executeScript("scrollBy(0,350)");
		Thread.sleep(200);
		// To Capture the Order Number
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******Order Number********");
		String orderno = driver.findElement(By.xpath("//*[@id='CenterForm']/form/table[1]/tbody/tr")).getText();
		System.out.println(orderno+" ");
		System.out.println();
		// To Capture Complete Billing Address
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******Billing Address********");
		String billing = driver.findElement(By.xpath("//*[@id='CenterForm']/form/table[2]/tbody")).getText();
		System.out.println(billing+" ");
		System.out.println();
		// To Capture Complete Shipping Address
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******Shipping Address********");
		String shipping = driver.findElement(By.xpath("//*[@id='CenterForm']/form/table[3]/tbody")).getText();
		System.out.println(shipping+" ");
		System.out.println();
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	}
	
	
	@Test
	public void testcase_7_SignOut_On_Website() throws InterruptedException {
	
		Thread.sleep(500);
		js.executeScript("scrollBy(0,300)");
		Thread.sleep(500);
		// Sign out the website
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		// Close the browser
		Thread.sleep(500);
		js.executeScript("scrollBy(0,300)");
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Closing Page Title : "+driver.getTitle());
		System.out.println("Closing Page Current URL : "+driver.getCurrentUrl());
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    Thread.sleep(3000);
	    driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

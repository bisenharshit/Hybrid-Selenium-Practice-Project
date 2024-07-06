package TestNG_Annotation_Flow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGListenersDemo implements ISuiteListener {

	WebDriver driver;

	public void onStart(ISuite suite) {
		System.out.println("Before Suite : " + suite);
	}

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/travels/mp-transport");

	}

	@Test
	public void testCase1() {
		System.out.println(driver.getTitle());
	}

	@Test
	public void testCase2() {
		System.out.println(driver.getCurrentUrl());
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public void onFinish(ISuite suite) {
		System.out.println("After Suite : " + suite);
	}
}

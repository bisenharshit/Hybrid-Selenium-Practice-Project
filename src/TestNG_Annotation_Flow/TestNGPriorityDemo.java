package TestNG_Annotation_Flow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//If we have't provide any priority in testNG it will executes in alphabetical manner of test-cases.
//But Suppose we can provide priority then it will execute according to the priority bases.
//And we also provide the Negative, Positive and Zero priority in testNG
public class TestNGPriorityDemo {

	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/travels/mp-transport");

	}

	@Test(priority = 1)
	public void a1() {
		System.out.println("TestCase A");
	}

	@Test(priority = 2)
	public void b2() {
		System.out.println("TestCase B");
	}

	@Test(priority = 3)
	public void c3() {
		System.out.println("TestCase C");
	}

	@Test(priority = 4)
	public void d4() {
		System.out.println("TestCase D");
	}

	@Test(priority = 5)
	public void e5() {
		System.out.println("TestCase E");
	}

	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}


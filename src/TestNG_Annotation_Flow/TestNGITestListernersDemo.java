package TestNG_Annotation_Flow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGITestListernersDemo implements ITestListener{

WebDriver driver;
	
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
		String actual =driver.getCurrentUrl();
		String expected = "https://www.redbus.in/travels/mp-transport";
		Assert.assertEquals(expected, actual);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
	  }

	  @Override
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("On Test Success");
	  }

	  @Override
	  public void onTestFailure(ITestResult result) {
		  System.out.println("On Test Failure");
	  }
	  @Override
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("On Test Skipped");
	  }

	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  System.out.println("On Test Fail with Success Percentage");
	  }

	  @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
		  System.out.println("On Test Fail With TimeOut");
	  }

	  @Override
	  public void onStart(ITestContext context) {
		  System.out.println("On Start");
	  }

	  @Override
	  public void onFinish(ITestContext context) {
		  System.out.println("On Finish");
	  }
}

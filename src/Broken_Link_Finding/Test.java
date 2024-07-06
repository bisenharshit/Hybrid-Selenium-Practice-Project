package Broken_Link_Finding;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	// To find the broken link from the footer in rahul shetty academy practice website
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,2000)");
		WebElement footer = driver.findElement(By.cssSelector("div[id='gf-BIG'] table tbody"));
		int linkcount = footer.findElements(By.tagName("a")).size();
		System.out.println("Total Link Count In Footer : "+linkcount);
		SoftAssert sf = new SoftAssert();
		for(int i=0; i<linkcount; i++) {
			String url = footer.findElements(By.tagName("a")).get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responsecode = conn.getResponseCode();
			System.out.println("Response Code Of URL : "+url+" is "+responsecode);
			sf.assertTrue(responsecode<400, "Response Code Of URL : "+url+" is "+responsecode);
		}
		sf.assertAll();
		Thread.sleep(3500);
		driver.close();
	}
}


/*class Test1 {
	// To find the broken link from the whole page in rahul shetty academy practice website
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,2000)");
		int linkcount = driver.findElements(By.tagName("a")).size();
		System.out.println("Total Link Count In Footer : "+linkcount);
		SoftAssert sa = new SoftAssert();
		for(int i=0; i<linkcount; i++) {
			String url = driver.findElements(By.tagName("a")).get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responsecode = conn.getResponseCode();
			
			sa.assertTrue(responsecode<400, "Response Code Of URL : "+url+" is "+responsecode+"with ");
				System.out.println();
			
			
		}
		Thread.sleep(3500);
		driver.close();
	}
}*/

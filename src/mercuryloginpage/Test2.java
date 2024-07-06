package mercuryloginpage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/login.php");
		String data = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[1]/font/b")).getText();
		System.out.println("Text value : "+data);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data);
		Thread.sleep(3000);
		driver.close();
	}
}


class Test1{
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		boolean b = driver.findElement(By.id("username")).isDisplayed();
		System.out.println(b);
		boolean b1 = driver.findElement(By.id("password")).isDisplayed();
		System.out.println(b1);
		boolean b2 = driver.findElement(By.id("submit")).isDisplayed();
		System.out.println(b2);
		
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String value = driver.findElement(By.xpath("//h1[@class=\"post-title\"]")).getText();
		Assert.assertEquals("Logged In Successfully", value);
		System.out.println("Login SucessFull Validation is Complete");
		
		Thread.sleep(2500);
		driver.close();
		
	}
}


class GoogleHomePageValidation{
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[text()='मराठी']")).click();
		String str = driver.findElement(By.xpath("//a[text()='बद्दल']")).getText();
		Assert.assertEquals("बद्दल", str);
		System.out.println("Page Language Change Validation Successfull");
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Google")) {
			System.out.println("We are Successfully Change The Language into Marathi");
		}else {
			System.out.println("We are not able to change the language");
		}
		Thread.sleep(3500);
		driver.close();
	}	
}


class FindElementLocation{
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		WebElement wb = driver.findElement(By.xpath("//input[@id='userName']"));
		Point po = wb.getLocation();
		System.out.println(po);
		System.out.println(po.getX()+" "+po.getY());
		
		Thread.sleep(2500);
		driver.close();
		
		 
		
		
		
	}
}








































package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObject1Test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disble-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("!!!!Automating the Swag Labs WebSite!!!!");
		driver.get("https://www.saucedemo.com/");
		
		// By using sendkeys and click method we used here
		driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("[id='password']")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[id='login-button']")).click();
		
		//if we don't  have any sendkeys and click method then 
		/*JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById(\"user-name\").value = \"standard_user\";");
		js.executeScript("document.getElementById(\"password\").value = \"secret_sauce\";");
		Thread.sleep(1000);
		js.executeScript("document.getElementById(\"login-button\").click();");*/
		
		//first product add into the cart
		driver.findElement(By.cssSelector("[id='item_4_title_link']"));
  
	 
		
	}
}

package IRCTC_Website_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCSourceDropDown {

	public static void main(String[] args) throws InterruptedException {		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		//Script for To picking the source place from drop down
		WebElement data = driver.findElement(By.xpath("//input[@class=\"ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]"));
		data.sendKeys("Gwal");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String data1 = "return document.querySelector('[class=\"ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]').value;";
		String value = (String)js.executeScript(data1);
		System.out.println(value);
		while(!value.equalsIgnoreCase("SINGWAL - SGW")) {
			System.out.println("In while Loop");
			Thread.sleep(2000);
			data.sendKeys(Keys.DOWN);
			data1 = "return document.querySelector('[class=\"ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]').value;";
			value = (String)js.executeScript(data1);
			System.out.println(value);
			
		}
		
		data.sendKeys(Keys.ENTER);
		
		Thread.sleep(3500);
		driver.close();
	}
}

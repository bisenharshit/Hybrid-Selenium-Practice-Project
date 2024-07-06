package IRCTC_Website_Automation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCDatePicker {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
		Thread.sleep(500);
		//We don't have the facility to automate year tab in IRCTC Application
		// So we can starts with the month only
		
		//Code For finding the months
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted'] [class='ui-datepicker-month ng-tns-c58-10 ng-star-inserted']")).getText().equalsIgnoreCase("August")) {
			System.out.println("Inside While Loop");
			Thread.sleep(200);
			driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted'] [class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']")).click();
		}
		
		
		//Code for finding the date
		int count = driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']")).size();
		for(int i=0; i<count; i++) {
			System.out.println("In for loop");
			Thread.sleep(200);
			String date = driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']")).get(i).getText();
			if(date.equalsIgnoreCase("15")) {
				driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']")).get(i).click();
				break;
			}
		}
		
		Thread.sleep(3500);
		driver.close();
	}
}

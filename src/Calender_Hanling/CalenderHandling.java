package Calender_Hanling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalenderHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
		
		while(!driver.findElement(By.cssSelector("[class=\"ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted\"] [class=\"ui-datepicker-year ng-tns-c58-10 ng-star-inserted\"]")).getText().equalsIgnoreCase("2024")) {
			System.out.println("In Year Finding");
			driver.findElement(By.cssSelector("[class=\"ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted\"] [class=\"ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10\"]")).click();
		}
		
		
		while(!driver.findElement(By.cssSelector("[class=\"ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted\"] [class=\"ui-datepicker-month ng-tns-c58-10 ng-star-inserted\"]")).getText().equalsIgnoreCase("June")) {
			System.out.println("In Month Finding");
			driver.findElement(By.cssSelector("[class=\"ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted\"] [class=\"ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10\"]")).click();
		}
		
	 	List<WebElement> date = driver.findElements(By.xpath("//a[@class='ui-state-default ng-tns-c58-10 ng-star-inserted']"));
	 	int dsize = date.size();
	 	System.out.println("Date Size : "+dsize);
	 	
	 	for (int i = 0; i < dsize; i++) {
	 		String str = driver.findElements(By.xpath("//a[@class='ui-state-default ng-tns-c58-10 ng-star-inserted']")).get(i).getText();
	 		System.out.println(str);
	 		if(str.equalsIgnoreCase("20")) {
	 			driver.findElements(By.xpath("//a[@class='ui-state-default ng-tns-c58-10 ng-star-inserted']")).get(i).click();
	 			System.exit(i);
	 		}
	 	}
	 	
		
	}
}

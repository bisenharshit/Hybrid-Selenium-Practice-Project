package Irctc_Drop_Down_Handle_General;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.xpath("//div[@class=\"ng-tns-c65-12 ui-dropdown ui-widget ui-state-default ui-corner-all\"]")).click();
		
		driver.findElement(By.xpath("//span[text()='LADIES']")).click();
		
		Thread.sleep(3500);
		driver.close();
	}
}

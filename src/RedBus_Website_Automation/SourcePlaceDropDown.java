package RedBus_Website_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SourcePlaceDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/travels/mp-transport");
		
		WebElement sr = driver.findElement(By.id("txtSource"));
		sr.sendKeys("Banga");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String jcity = "return document.getElementById(\"txtSource\").value;";
		String city = (String)js.executeScript(jcity);
		System.out.println(city);
		while(!city.equalsIgnoreCase("Bangalore")) {
			System.out.println("In while loop");
			Thread.sleep(2000);
			sr.sendKeys(Keys.DOWN);
			jcity = "return document.getElementById(\"txtSource\").value;";
			city = (String)js.executeScript(jcity);
			System.out.println(city);
		}
		sr.sendKeys(Keys.ENTER);
	}
}

package KSRTC_JavaScript_Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.ksrtc.in/oprs-web/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 400)");

		WebElement fp = driver.findElement(By.id("fromPlaceName"));
		fp.sendKeys("BENG");

		String jcityname = "return document.getElementById(\"fromPlaceName\").value";

		String cityname = (String) js.executeScript(jcityname);
		System.out.println(cityname);

		while (!cityname.equalsIgnoreCase("BENGALURU AIRPORT")) {
			System.out.println("While Loop For Finding Place");
			Thread.sleep(1000);
			fp.sendKeys(Keys.DOWN);

			jcityname = "return document.getElementById(\"fromPlaceName\").value";

			cityname = (String) js.executeScript(jcityname);
			System.out.println(cityname);

		}

		fp.sendKeys(Keys.ENTER);
		System.out.println("Successfull Selection Of From Place");
		System.out.println();
		WebElement tp = driver.findElement(By.id("toPlaceName"));
		tp.sendKeys("BA");

		String jcityname1 = "return document.getElementById(\"toPlaceName\").value";

		String cityname1 = (String) js.executeScript(jcityname1);
		System.out.println(cityname1);

		while (!cityname1.equalsIgnoreCase("BANASHANKARI BMTC TTMC")) {
			System.out.println("In while loop2 For finding city");
			Thread.sleep(1000);
			tp.sendKeys(Keys.DOWN);
			jcityname1 = "return document.getElementById(\"toPlaceName\").value";
			cityname1 = (String) js.executeScript(jcityname1);
			System.out.println(cityname1);
		}
		tp.sendKeys(Keys.ENTER);
		System.out.println("Successfull Selection Of To Place");
		driver.findElement(By.id("txtJourneyDate")).click();

		while (!driver.findElement(By.cssSelector(
				"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-datepicker-year\"]"))
				.getText().equalsIgnoreCase("2024")) {
			System.out.println("In while for Year Findings");
			driver.findElement(By.cssSelector(
					"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-icon ui-icon-circle-triangle-e\"]"))
					.click();
		}

		while (!driver.findElement(By.cssSelector(
				"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-datepicker-month\"]"))
				.getText().equalsIgnoreCase("June")) {
			System.out.println("In while for Month Findings");
			driver.findElement(By.cssSelector(
					"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-icon ui-icon-circle-triangle-e\"]"))
					.click();
		}

		List<WebElement> dates = driver.findElements(By.cssSelector("a[class*='ui-state-default']"));
		System.out.println(dates.size());

		for (int i = 0; i < dates.size(); i++) {
			System.out.println("Dates Selection for loop");
			String date = driver.findElements(By.cssSelector("a[class*='ui-state-default']")).get(i).getText();
	
			if (date.equalsIgnoreCase("5")) {
				driver.findElements(By.cssSelector("a[class*='ui-state-default']")).get(i).click();
				break;
			}

		}
		System.out.println("Successfull Selection of Departure Date");
		
		driver.findElement(By.id("txtReturnJourneyDate")).click();
		
		while (!driver.findElement(By.cssSelector(
				"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-datepicker-year\"]"))
				.getText().equalsIgnoreCase("2024")) {
			System.out.println("In while for Year Findings");
			driver.findElement(By.cssSelector(
					"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-icon ui-icon-circle-triangle-e\"]"))
					.click();
		}
		
		while (!driver.findElement(By.cssSelector(
				"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-datepicker-month\"]"))
				.getText().equalsIgnoreCase("June")) {
			System.out.println("In while for Month Findings");
			driver.findElement(By.cssSelector(
					"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-icon ui-icon-circle-triangle-e\"]"))
					.click();
		}

		List<WebElement> dates1 = driver.findElements(By.cssSelector("a[class*='ui-state-default']"));
		System.out.println(dates1.size());

		for (int i = 0; i < dates1.size(); i++) {
			System.out.println("Dates Selection for loop");
			String date1 = driver.findElements(By.cssSelector("a[class*='ui-state-default']")).get(i).getText();
			if (date1.equalsIgnoreCase("8")) {
				driver.findElements(By.cssSelector("a[class*='ui-state-default']")).get(i).click();
				 break;
				
			}

		}
		
		System.out.println("Successfull Selection of Return Date");
		
		// For  for ladies Selection
		//driver.findElement(By.cssSelector("[class='custom-control-label']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class='btn btn-primary btn-lg btn-block btn-booking']")).click();
        System.out.println("Successfully Search for the Buses");
		
		Thread.sleep(3500);
		driver.close();
	}
}

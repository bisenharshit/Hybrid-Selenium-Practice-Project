package Calender_Hanling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");

		driver.findElement(By.cssSelector("[id='onwardCal']")).click();
		String data = driver
				.findElement(By.xpath(""))
				.getText();
		
		//System.out.println(data);
		// String data1 =
		// driver.findElement(By.xpath("//div[@class=\"DayNavigator__CalendarHeader-qj8jdz-1
		// fxvMrr\"]/child :: div[2]")).getText();
		// String data1 =
		// driver.findElement(By.xpath("//div[@class='holiday_count']")).getText();
		while (!data.equalsIgnoreCase("Jun")) {
			data = driver
					.findElement(
							By.xpath("//div[@class=\"DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr\"]/child :: div[2]"))
					.getText();
			System.out.println(data);
			driver.findElement(
					By.xpath("//div[@class=\"DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr\"]/child :: div[3]")).click();
		}

	}
}








// By using chat GPT
class RedBusDatePickerAutomation {
	public static void main(String[] args) {
		// Set the path of chromedriver.exe
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Initialize ChromeDriver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);

		// Launch RedBus website
		driver.get("https://www.redbus.in/");

		// Locate and click on the date picker element
		WebElement datePicker = driver.findElement(By.xpath("//input[@id='onward_cal']"));
		datePicker.click();

		// Select the desired date (e.g., 15th day of the current month)
		WebElement date = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@data-day='15']"));
		date.click();

		// Close the date picker
		Actions actions = new Actions(driver);
		actions.moveToElement(datePicker).click().perform();

		// Close the browser
		driver.quit();
	}
}

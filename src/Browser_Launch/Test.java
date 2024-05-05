package Browser_Launch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("!!**Hello This is Selenium Automation**!!"
				+ "This is Selenium Browser Launch Script"
				+ "This Script written by Harshit Bisen");
	
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		Thread.sleep(500);
		driver.close();
	}
}

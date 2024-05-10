package Total_Hy_Link_Web_Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/");
		
		//To find the total number hyperlink in this page
		List<WebElement> totalhyperlink = driver.findElements(By.tagName("a"));
		System.out.println("Total Hyperlink Size: "+totalhyperlink.size());
		System.out.println();
		int i = 1;
		System.out.println("**!!Total Hyperlink List Of Webpage!!**");
		System.out.println("///////////////\\\\\\\\\\\\\\\\\\\\\\\\");
		for(WebElement str : totalhyperlink) {
			System.out.println("Hyperlink Number "+i+" : -- "+str);
			i++;
		}
		Thread.sleep(2000);
		driver.close();
		
		
	}
}

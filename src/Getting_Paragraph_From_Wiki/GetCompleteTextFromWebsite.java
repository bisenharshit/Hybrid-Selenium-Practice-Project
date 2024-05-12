package Getting_Paragraph_From_Wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCompleteTextFromWebsite {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://en.wikipedia.org/wiki/India");
		
		String str = driver.findElement(By.xpath("//div[@class=\"mw-content-ltr mw-parser-output\"]")).getText();
		
		System.out.println(str);
		
		Thread.sleep(1000);
		driver.close();
	}
}

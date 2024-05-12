package Nokia_Text_Find_In_Amazon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
	//	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nokia");
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		System.out.println("Successfully Search Product Nokia in Amazon");
		
		List<WebElement> element = driver.findElements(By.xpath("//*[contains (text(), 'Nokia')]"));
		
		for(WebElement str :element) {
		System.out.println(":::::: "+str.getText());
		}
		
		driver.close();
	     Thread.sleep(2000);
		
	}
}

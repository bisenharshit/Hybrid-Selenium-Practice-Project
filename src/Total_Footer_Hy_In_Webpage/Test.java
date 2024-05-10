package Total_Footer_Hy_In_Webpage;

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
		driver.get("https://www.bequant.com/");
		
		WebElement footer = driver.findElement(By.xpath("//footer[@class='s-footer']"));
		List<WebElement> flink =  footer.findElements(By.tagName("a"));
		System.out.println("Total Footer Link : "+flink.size());
		int i = 1;
		for(WebElement f : flink) {
			System.out.println("Footer link Number "+i+" : -- "+f);
			i++;
		}
		
		Thread.sleep(2000);
		driver.close();
	}
}

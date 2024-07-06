package MultipleWindowHandling;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		System.out.println("Sucessfully launch the browser");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Mobiles");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(500);
		System.out.println();
		List<WebElement> phonelist = driver.findElements(By.xpath("//div[@class='col col-7-12']"));
		int phonecount = phonelist.size();
		int count = 0;
		for (int i = 0; i < phonecount; i++) {
			Thread.sleep(500);
			if (count != 5) {
				driver.findElements(By.xpath("//div[@class='col col-7-12']")).get(i).click();
				count++;
				System.out.println(count);
			}
		}

		Set<String> win = driver.getWindowHandles();
		System.out.println(win);
		Iterator<String> itr = win.iterator();
		String str = "";
		while (itr.hasNext()) {
			String val = itr.next();
			System.out.println(val);

			if (!str.equals("Mobiles- Buy Products Online at Best Price in India - All Categories | Flipkart.com")) {
				driver.switchTo().window(val);
				str = driver.getTitle();
				System.out.println(str);
			}
		}
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.quit();
	}
}

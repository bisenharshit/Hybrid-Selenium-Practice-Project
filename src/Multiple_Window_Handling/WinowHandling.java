package Multiple_Window_Handling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver.WindowType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WinowHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4400)");

		js.executeScript("window.open('https://www.restapitutorial.com/')");
		Thread.sleep(500);
		js.executeScript("window.open('https://www.soapui.org/')");
		Thread.sleep(500);
		js.executeScript("window.open('https://jmeter.apache.org/')");
		Thread.sleep(500);
		String newTab = driver.getWindowHandles().stream().filter(handle -> !handle.equals("")).findFirst().get();
		driver.switchTo().window(newTab);

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		WebElement data = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		data.sendKeys("India");
		String data1 =  data.getAttribute("value");
		System.out.println(data1);
		Thread.sleep(3000);
	    
		driver.quit();
	}
}

/*
 * WebElement footer =
 * driver.findElement(By.cssSelector("[class='nI-gNb-footer__top-container']"));
 * 
 * List<WebElement> noofhyperlink =
 * footer.findElements(By.cssSelector("[class=\"nI-gNb-column\"]")); int
 * noofhyperlink1 = noofhyperlink.size();
 * System.out.println("Number Of Hyper Link On The Web Page = " +
 * noofhyperlink1);
 * 
 * for (int i = 0; i < noofhyperlink1; i++) { System.out.println("In For Loop");
 * String key = Keys.chord(Keys.CONTROL, Keys.ENTER); // This is Enum. Same Like
 * Actions Class but enum is // better.
 * footer.findElements(By.tagName("a")).get(i).sendKeys(key);
 * 
 * Thread.sleep(2000); } // to handle multiple window. Set<String> wk =
 * driver.getWindowHandles(); System.out.println(wk);
 * 
 * ArrayList<String> al = new ArrayList<>(wk);
 * 
 * Iterator<String> itr = al.iterator(); while (itr.hasNext()) {
 * driver.switchTo().window(itr.next()); String titlename = driver.getTitle();
 * System.out.println("Title Name = " + titlename); Thread.sleep(2000);
 * 
 * /* if (titlename.equalsIgnoreCase("REST API Tutorial")) {
 * driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/ul/ul/li[1]/a"))
 * .click(); } // driver.close(); }
 */
/*
 * Thread.sleep(5000); driver.quit(); }
 */

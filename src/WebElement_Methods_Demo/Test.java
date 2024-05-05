package WebElement_Methods_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		  
		  System.out.println("Hi Selenium " +
		  "This is WebElement Sendkeys Method Demo");
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
		  );
		  
		  WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		  driver.get(
		  "file:///C:/Users/91870/Desktop/HTML%20Login%20page/index%20(1).html");
		  
		  WebElement id = driver.findElement(By.id("uid"));
		  id.sendKeys("hello");
		  
		 boolean b =  id.isDisplayed();
		 System.out.println("Element is Diplayed : "+b);
		 
		 WebElement rember =  driver.findElement(By.id("remem"));
		 boolean b1 =  rember.isSelected();
		 System.out.println("Element is Selected : "+b1);
		 
		 WebElement button = driver.findElement(By.xpath("//button[@id='login']"));
		 boolean b2 =   button.isEnabled();
		 System.out.println("Element is Enabled : "+b2);
		 
		 id.clear();
		 System.out.println("Clear the element successfully");
	}
}

package Hyperlink_Finding;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindHyperlinks {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/travels/mp-transport");
		
		//Total Hyperlink available on web-page
		int totallink = driver.findElements(By.tagName("a")).size();
		System.out.println("Total Hyperlink On Webpage : "+totallink);
		
		System.out.println();
		
		//To find Total hyperlink on the Header of webpage
	 	WebElement header1 = driver.findElement(By.xpath("//div[@class=\"D121_header_wrapper\"]"));
	 	WebElement header2 = driver.findElement(By.xpath("//div[@class=\"C122_breadCrumb\"]"));
	 	WebElement header3 = driver.findElement(By.xpath("//div[@class=\"D120_wrap_v2\"]"));
	 	
	 	int header1count = header1.findElements(By.tagName("a")).size();
	 	int header2count = header2.findElements(By.tagName("a")).size();
	 	int header3count = header3.findElements(By.tagName("a")).size();
	 	
	 	int totalcountheader = header1count +header2count + header3count;
	 	System.out.println("Header 1 : "+header1count+" Header 2 : "+header2count+" Header 3 : "+header3count);
	 	System.out.println("Total Header Link on Webpage : "+totalcountheader);
		
	 	System.out.println();
		
		//To find Total hyperlink on the Footer of webpage
	 	WebElement footer1 = driver.findElement(By.xpath("//div[@class=\"D109_footerLink\"]"));
	 	WebElement footer2 = driver.findElement(By.xpath("//section[@class=\"D159_main\"]"));
	 	WebElement footer3 = driver.findElement(By.xpath("//footer[@class=\"C111_footer\"]"));
	 	
	 	int footer1count = footer1.findElements(By.tagName("a")).size();
	 	int footer2count = footer2.findElements(By.tagName("a")).size();
	 	int footer3count = footer3.findElements(By.tagName("a")).size();
	 	
	 	int totalcountfooter = footer1count +footer2count + footer3count;
	 	System.out.println("Footer 1 : "+footer1count+" Footer 2 : "+footer2count+" Footer 3 : "+footer3count);
	 	System.out.println("Total Footer Link on Webpage : "+totalcountfooter);
	 	
	 	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/ul/li[3]/a")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
	 	
	 	Thread.sleep(2500);
//	 	driver.close();
	}
}

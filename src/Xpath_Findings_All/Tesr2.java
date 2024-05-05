package Xpath_Findings_All;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tesr2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		// By absolute X-path
		WebElement fname = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
		fname.sendKeys("Harshit");
		Thread.sleep(2000);
		fname.clear();
		System.out.println("Absolute X-path is Success");
		// By Relative X-path
		WebElement fname1 = driver.findElement(By.xpath("//input[@name='firstName']"));
		fname1.sendKeys("Harshit");
		Thread.sleep(2000);
		fname1.clear();
		System.out.println("Relative X-path is Success");
		// By Dynamic X-path Parent Concept
		WebElement fname2 = driver.findElement(
				By.xpath("//form[@action='register.php']/table/tbody/tr[2]/td[2]/input/parent :: td/input"));
		fname2.sendKeys("Harshit");
		Thread.sleep(2000);
		fname2.clear();
		System.out.println("Dynamic X-path is Success with Parent Concept");
		// By Dynamic X-path Child Concept
		WebElement fname3 = driver
				.findElement(By.xpath("//form[@action='register.php']/table/tbody/tr[2]/td[2]/child :: input"));
		fname3.sendKeys("Harshit");
		Thread.sleep(2000);
		fname3.clear();
		System.out.println("Dynamic X-path is Success with Child Concept");
		// By Dynamic X-path Sibling Concept with Preceding-Sibling
		WebElement fname4 = driver
				.findElement(By.xpath("//form[@action='register.php']/table/tbody/tr[2]/td[2]/child :: input"));
		fname4.sendKeys("Harshit");
		Thread.sleep(2000);
		fname4.clear();
		System.out.println("Dynamic X-path is Success Sibling Concept with Preceding Sibling");
		
		
	}
}

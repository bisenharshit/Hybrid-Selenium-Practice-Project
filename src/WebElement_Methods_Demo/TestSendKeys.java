package WebElement_Methods_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSendKeys {

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * System.out.println("Hi Selenium " +
	 * "This is WebElement Sendkeys Method Demo");
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
	 * );
	 * 
	 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
	 * driver.get(
	 * "file:///C:/Users/91870/Desktop/HTML%20Login%20page/index%20(1).html");
	 * 
	 * WebElement username = driver.findElement(By.id("uid"));
	 * username.sendKeys("harshitbise94");
	 * 
	 * /* WebElement login = driver.findElement(By.id("remem")); login.click();
	 */

	/*
	 * WebElement login1 = driver.findElement(By.id("remem")); login1.click();
	 */

	/*
	 * WebElement getData = driver.findElement(By.xpath("//label[@for='uname']"));
	 * String gettext = getData.getText(); System.out.println(gettext);
	 */

	/*
	 * String value = username.getAttribute("value"); System.out.println(value);
	 */

	/*
	 * Thread.sleep(500); username.clear();
	 */

	/*
	 * WebElement remember = driver.findElement(By.id("remem")); remember.click();
	 */

	/*
	 * WebElement login = driver.findElement(By.xpath("//button[@id='login']"));
	 * login.submit();
	 */
/*
	}
*/

	public static void main(String[] args) throws InterruptedException {
		// Created By The Harshit Bisen TB-18(Offline)
		System.out.println("Welcome To Selenium");
		System.out.println("With All Requied Web Element Methods On The HTML Page");
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("file:///C:/Users/91870/Desktop/HTML%20Login%20page/index%20(1).html");

		driver.manage().window().maximize();
		Thread.sleep(500);
		WebElement u = driver.findElement(By.id("uid"));
		u.sendKeys("harshitbisen5"); // Method-1 sendKeys();
		Thread.sleep(500);
//		WebElement login = driver.findElement(By.id("login"));
//		login.click();                                                   // Method-2 click();
		Thread.sleep(500);
		WebElement pas = driver.findElement(By.xpath("//label[@for='password']"));
		String s1 = pas.getText(); // Method-3 getText();
		System.out.println("Text = " + s1);
		Thread.sleep(500);
		String s2 = u.getAttribute("value"); // Method-4 getAttribute();
		System.out.println("Attribute Value = " + s2);
		Thread.sleep(500);
		u.clear(); // Method-5 clear();
		Thread.sleep(500);
//		WebElement submit1 = driver.findElement(By.id("login"));
//		submit1.submit();                                                // Method-6 submit();
		Thread.sleep(500);
		WebElement display = driver.findElement(By.id("uid"));
		boolean b = display.isDisplayed(); // Method-7 isDisplayed();
		System.out.println("Is Displayed Method Output = " + b);
		Thread.sleep(500);
		WebElement select = driver.findElement(By.id("remem"));
		boolean b1 = select.isSelected(); // Method-8 isSelected();
		System.out.println("Is Selected Method Output = " + b1);
		Thread.sleep(500);
		WebElement enable = driver.findElement(By.id("login"));
		boolean b2 = enable.isEnabled();
		System.out.println("Is Enabled Method Output = " + b2); // Method-9 isEnabled();

		Thread.sleep(3000);
		driver.close();
	}
}

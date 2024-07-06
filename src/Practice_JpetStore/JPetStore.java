package Practice_JpetStore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JPetStore {

	public static void main(String[] args) throws InterruptedException {
		
		//In Registration Page By using all kinds of Dynamic X-path
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
		
		//Scroll The page for alignment of elements with proper visibility
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,400)");
		
		//UserID -- By Preceding Sibling X-path
		WebElement username = driver.findElement(By.xpath("//span[@class='error-msg']/preceding-sibling :: input[@name='username']"));
		username.sendKeys("emmawatson123");
		String uname = username.getAttribute("value");
		//UserID Text -- By Child Concept X-path
		WebElement utext = driver.findElement(By.xpath("//tr[1]/child :: td[text()='User ID:']"));
		String utext1 = utext.getText();
		System.out.println(utext1+" "+uname);
		
		//New Password -- By Immediate Following Sibling X-path
		WebElement newpassword = driver.findElement(By.xpath("//tr/following-sibling ::*[1]/td[2]/input[@name='password']"));
		newpassword.sendKeys("Emma@123");
		String newpass = newpassword.getAttribute("value");
		//New Password Text -- By Immediate Preceding Sibling X-path
		WebElement newpass1 =driver.findElement(By.xpath("//tr/preceding-sibling ::*[1]/td[text()='New password:']"));
		String newp = newpass1.getText();
		System.out.println(newp+" "+newpass);
		
		//Confirm Password -- By Parent Concept X-path
		WebElement confirmpassword = driver.findElement(By.xpath("//span[@class='error-msg']/parent :: td[1]/input[@name='repeatedPassword']"));
		confirmpassword.sendKeys("Emma@123");
		String cpassword = confirmpassword.getAttribute("value");
		//Confirm Password Text -- By Child Concept X-path
		WebElement cpass = driver.findElement(By.xpath("//tr[3]/child :: td[text()='Confirm password:']"));
		String cpass1 = cpass.getText();
		System.out.println(cpass1+" "+cpassword);
		
		//First Name -- By Relative X-path Concept
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstname.sendKeys("Emma");
		String firstname1 = firstname.getAttribute("value");
		//First Name Text -- By Absolute X-path Concept
		WebElement fname = driver.findElement(By.xpath("/html/body/section/div[2]/div[2]/div/form/table[2]/tbody/tr[1]/td[1]"));
		String fname1 =fname.getText();
		System.out.println(fname1+" "+firstname1);
		
		//Last Name -- By Preceding Sibling X-path
		WebElement lastname = driver.findElement(By.xpath("//tr/preceding-sibling ::*[1]/td[2]/input[@name='lastName']"));
		lastname.sendKeys("Watson");
		String lastname1 = lastname.getAttribute("value");
		//Last Name Text -- By Preceding Sibling X-path
		WebElement lname = driver.findElement(By.xpath("//td[2]/preceding-sibling :: td[text()='Last name:']"));
		String lname1 =lname.getText();
		System.out.println(lname1+" "+lastname1);
		
		//To close the Browser
		Thread.sleep(4000);
		driver.close();
		
		
	}
}

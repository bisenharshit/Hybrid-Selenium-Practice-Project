package Cookies_Demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	    Set<Cookie> cook = driver.manage().getCookies();
	    System.out.println("Total Cookie Size : "+cook.size());
	    for(Cookie ck :cook) {
	    	System.out.println("Cookie Domain : "+ck.getDomain());
	    	System.out.println("Cookie Name : "+ck.getName());
	    	System.out.println("Cookie Path : "+ck.getPath());
	    	System.out.println("Cookie Value : "+ck.getValue());
	    	System.out.println("Cookie Expiry : "+ck.getExpiry());
	    	System.out.println("Cookie HTTP Security : "+ck.isHttpOnly());
	    	System.out.println("Cookie Security : "+ck.isSecure());
	    	System.out.println("To String Result : "+ck.toString());
	    	System.out.println("To JSON Result : "+ck.toJson());
	    	System.out.println();
	    }
	
	    Thread.sleep(2000);
	    driver.close();
	}
}

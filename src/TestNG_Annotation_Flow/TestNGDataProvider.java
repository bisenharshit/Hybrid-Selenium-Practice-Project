package TestNG_Annotation_Flow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDataProvider {

	
	@Test(dataProvider = "getData")
	public void testCase1(Map<String, String> map) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/login.php");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(map.get("user"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(map.get("pass"));
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		driver.close();
	}
	
	//By using lazy loading
	@DataProvider
	public Object[][] getData() {
		
		//By using the HashMap
		Map<String, String> map = new HashMap<>();
		map.put("user", "QQQQ");
		map.put("pass", "qqqq");
		
		Map<String, String> map1 = new HashMap<>();
		map1.put("user", "ZZZZ");
		map1.put("pass", "zzzz");
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("user", "PPPP");
		map2.put("pass", "pppp");
		
		//By using the ArrayList
		/*List<String> map = new  ArrayList<>();
		map.add("QQQQ");
		map.add("qqqq");
		
		List<String> map1 = new  ArrayList<>();
		map1.add("ZZZZ");
		map1.add("zzzz");
		
		List<String> map2 = new  ArrayList<>();
		map2.add("PPPP");
		map2.add("pppp");*/
		
	
		return new Object[][] {{map}, {map1}, {map2}};
//		return new Object[][] {{"QQQQ", "qqqq"},{"ZZZZ", "zzzz"}, {"PPPP", "pppp"}};
	}
	
	//By using Egar Loading
	//Not Recommended to use because Quite  in syntax 
	//@DataProvider
	/*public Object[][] getData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "QQQQ";
		obj[0][1] = "qqqq";
		obj[1][0] = "ZZZZ";
		obj[1][1] = "zzzz";
		obj[2][0] = "PPPP";
		obj[2][1] = "pppp";
		return obj;
	}*/
	
	
}

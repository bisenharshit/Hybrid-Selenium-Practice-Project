package Sorting_TablesWebElements_By_JavaStreams;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// To find the list of items and after sorting validate actual and sorted.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//th[@role=\"columnheader\"][1]")).click();

		List<WebElement> values = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = values.stream().map(val -> val.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertEquals(originalList, sortedList);

		System.out.println("Comparision Successfull");

		Thread.sleep(2500);
		driver.close();
	}
}

class Test1 {

	public static void main(String[] args) {
		// I want to get Price for all the veg available on page 1
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//th[@role=\"columnheader\"][1]")).click();
		List<String> originalList;
		do {
		List<WebElement> values = driver.findElements(By.xpath("//tr/td"));

		originalList = values.stream().filter(m->m.getText().contains("Cheese")).map(m->veggiePrice(m)).collect(Collectors.toList());
		originalList.forEach(s->System.out.println(s));
		
		if(originalList.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(originalList.size()<1);
		
	}
	private static String veggiePrice(WebElement p) {
		
		String val = p.findElement(By.xpath("following-sibling :: td[1]")).getText();
		
		return val;
	}
}

class Test2{
	// Open Url1 and then go to with url2 and the url2 and come to the base page and send into the text box
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.navigate().to("https://demo.guru99.com/test/newtours/login.php");
		String url =driver.getCurrentUrl();
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(url);
		Thread.sleep(2500);
		driver.close();
	}
	
}

class Test3{
	//Take the mobile name which have less than 10000 prize in amazon.com
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
		Thread.sleep(1000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,440)");
		//By using jdk 8 in optimized manner
		List<WebElement> price = driver.findElements(By.cssSelector("span[class='a-price-whole']"));
		List<Integer> devicecost = price.stream().map(m->Integer.parseInt(m.getText().replace(",", ""))).filter(m->m<10000).collect(Collectors.toList());
		devicecost.forEach(s->System.out.print(s+" "));
		
		//By traditional approach with before jdk 8 
		System.out.println();
		int price2 = driver.findElements(By.cssSelector("span[class='a-price-whole']")).size();
		for(int i=0; i<price2; i++) {
			String val = driver.findElements(By.cssSelector("span[class='a-price-whole']")).get(i).getText();
			String name = driver.findElements(By.cssSelector("span[class=\"a-size-medium a-color-base a-text-normal\"]")).get(i).getText();
			String val1 = val.replace(",", "");
			int price1 = Integer.parseInt(val1);
			if(price1 > 10000) {
				System.out.println(price1+" -- "+name.split(" ")[0]+"-"+name.split(" ")[1]);
				System.out.println();
			}
		}
		Thread.sleep(2500);
		driver.quit();
	}
}


class Test4{
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/s?k=Mobile&crid=311UQ6GSOVXZZ&sprefix=mobile%2Caps%2C326&ref=nb_sb_noss_1");
		List<WebElement> val = driver.findElements(By.xpath("//*[contains (text(), 'FREE')]"));
		for(int i=0; i<val.size(); i++) {
			String str =driver.findElements(By.xpath("//*[contains (text(), 'FREE')]")).get(i).getText();
			System.out.println(str);
		}
		Thread.sleep(3500);
		driver.close();
	}
}


































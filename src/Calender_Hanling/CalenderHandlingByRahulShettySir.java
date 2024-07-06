package Calender_Hanling;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandlingByRahulShettySir {

	
	public static void main(String[] args) throws InterruptedException {
		String year = "2024";
		String month = "06";
		String date = "30";
		String expected = date+"/"+month+"/"+year;
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
		driver.findElement(By.xpath("//span[@class='ui-datepicker-year ng-tns-c58-10 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//span[@class='ui-datepicker-month ng-tns-c58-10 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
		
		String actual = driver.findElement(By.xpath("//input[@class=\"ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted\"]")).getAttribute("value");
		System.out.println(actual);
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		System.out.println("SucessFully Validate the date which is entered");
		Thread.sleep(4000);
		driver.quit();
		
	}
}

//class TestArray{
//	
//	 public static void main(String[] args) {
//         //To find the missing element from an array
//        int[] arr = {1,2,5,4,1,6};
//        Set<Integer> set = new HashSet<>();
//        for(int i=0; i<arr.length; i++){
//            set.add(arr[i]);
//        }
//        List<Integer> al = new ArrayList<>(set);
//        Object[] oarr = al.toArray();
//
//        for(int i=0; i<oarr.length; i++){
//          arr[i] = (int)oarr[i];
//        }
//        
//        for(int j : arr){
//            System.out.println(j);
//        }
//        
//        int n = arr.length+1;
//        int sum = (n*(n+1))/2;
//        
//        for(int i=0; i<arr.length; i++){
//            sum = sum - arr[i];
//        }
//        System.out.println("Missing Array Element Is : "+sum);
//    }
//}




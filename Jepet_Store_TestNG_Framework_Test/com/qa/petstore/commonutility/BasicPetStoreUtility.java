package com.qa.petstore.commonutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.petstore.test.PetStoreTest;


public class BasicPetStoreUtility {

	public WebDriver driver;
	
	public String taking_Screenshots_of_Websites(String testcase, WebDriver driver) throws IOException {
		this.driver=driver;
		File src =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Reports//" + testcase + ".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir") + "//Reports//" + testcase + ".png";
	}
	
	
	public static Properties gettingDataFromPropertyFile() throws IOException {
		Properties ps = new Properties();
		FileInputStream fis = new FileInputStream("Jpet_Store_TestNG_Framework_Resources//JPet Properties File//Data.properties");
		ps.load(fis);
		return ps;
		
	}
	
	
	

	
}

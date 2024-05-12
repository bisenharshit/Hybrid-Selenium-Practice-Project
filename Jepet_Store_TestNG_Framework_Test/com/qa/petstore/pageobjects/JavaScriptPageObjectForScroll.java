package com.qa.petstore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptPageObjectForScroll {
	
	WebDriver driver;
	
	public JavaScriptPageObjectForScroll(WebDriver driver) {
		this.driver = driver;
	}
	
	public void javaScriptScrollMethod(int i, int i1) {
		JavascriptExecutor	js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy("+i+","+i1+")");
	}
}

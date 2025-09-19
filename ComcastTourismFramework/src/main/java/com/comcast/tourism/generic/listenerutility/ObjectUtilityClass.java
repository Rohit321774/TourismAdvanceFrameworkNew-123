package com.comcast.tourism.generic.listenerutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
/**
 * 
 * @author Rohit
 * This Class is required as Listeners to participate in the Parallel Exection
 */
public class ObjectUtilityClass {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest actTest) { 
		test.set(actTest);
	}
	public static WebDriver getDriver() {
		
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver) { 
		driver.set(actDriver);
	}


}

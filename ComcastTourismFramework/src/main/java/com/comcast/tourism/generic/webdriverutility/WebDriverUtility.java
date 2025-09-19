package com.comcast.tourism.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
/**
 * I Have created this class  to deal with webElement Present on  WebApplication
 * @author Rohit
 */

public class WebDriverUtility {
	/**
	 * Method to maximize the Window
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver) {
		

		driver.manage().window().maximize();

	}
	/**
	 * 	@author Rohit
	 * Method to Load The Window the Window
	 */

	public void toLoadPage(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}
}

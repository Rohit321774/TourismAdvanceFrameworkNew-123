package com.comcast.tourismtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.tourism.generic.basetest.BaseClass;
import com.comcast.tourism.generic.fileUtility.PropertyFileUtility;
import com.comcast.tourism.generic.objectrepositoryUtility.AdminLogin;
import com.comcast.tourism.generic.webdriverutility.WebDriverUtility;

/**
 * This class is responsible for login as admin to application.
 * <
 * It extends the {BaseClass}, which contains the basic/common functionality
 * needed for the framework.
 */

@Listeners(com.comcast.tourism.generic.listenerutility.ListenerImplementationClass.class)
public class LoginAsAdminTest extends BaseClass {
	
	@Test(groups = {"Smoke","Regrresion"})
	
	/**
	 * /**
	 * this @Test contains bussines method to login as admin 
	 * 
	 */

	public void loginAsAdminTest() throws IOException {
	//	ObjectUtilityClass.test.log(Status.INFO,"TO GET DATA FROM PROPERTY FILES");
	/**
	 * This is the property to fetch the common Data
	 * 	
	 */
		PropertyFileUtility file = new PropertyFileUtility();
		String url = file.getDataFromPropertyFiles("url");
		String username = file.getDataFromPropertyFiles("username");
		String password = file.getDataFromPropertyFiles("password");

		WebDriverUtility wb = new WebDriverUtility();
		wb.windowMaximize(driver);
		wb.toLoadPage(driver);

		AdminLogin adminLogin = new AdminLogin(driver);
		adminLogin.AdminLoginToApplication(url, username, password);

		String adminHeader = driver.findElement(By.xpath("//div[@class='user-name']")).getText();
		if (adminHeader.equals(adminHeader)) {
			System.out.println("Admin login Succesfully:::");
		} else {
			System.out.println("Admin login  Not Succesfully:::");
		}

		adminLogin.AdminLogoutToApplication();
		adminLogin.getAdminBackToHomepage().click();

	}
}
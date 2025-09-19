package com.comcast.tourism.generic.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.tourism.generic.fileUtility.PropertyFileUtility;
import com.comcast.tourism.generic.listenerutility.ObjectUtilityClass;

/**
 * This is the baseClass which consist of the All CONFIGURATION ANNOTATION and
 * will Commom for the all The Scritps and which contains the basic/common functionality
 * needed for the framework.
 * 
 * @author Rohit
 */
public class BaseClass {
	public WebDriver driver;
	public static WebDriver Sdriver;

	/**
	 * To Fetch The Data from Property Files
	 * 
	 * @author Rohit
	 */
	PropertyFileUtility file = new PropertyFileUtility();

	/**
	 * This annoation is used for the Database Connectivity and for the report
	 * Confuguration before any test Scripts Executes
	 * 
	 * @throws SQLException
	 */

	/**
	 * Using The Groups Execution for Running a particular TestScipts Which is
	 * spcific like Smoke ,regression ,System testing:::
	 * 
	 * @throws SQLException
	 */
	@BeforeSuite(groups = { "Smoke", "Regression" })

	public void ConfigBS() throws SQLException {
		System.out.println("DataBase Connection, Report Configuration");
	}

	/**
	 * Using The Groups Execution for Running a particular TestScipts Which is
	 * spcific like Smoke ,regression ,System testing:::
	 * 
	 * @throws SQLException
	 */

	/**
	 * This annoation is used for thr Launching The Browser::
	 * 
	 * @throws SQLException
	 */

	// @Parameters("Browser");
	@BeforeClass(groups = { "Smoke", "Regression" })
	public void ConfigBC() throws SQLException, IOException {
		System.out.println("To launch Browser");

		String browser = file.getDataFromPropertyFiles("browser");
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		Sdriver = driver;
		ObjectUtilityClass.setDriver(driver);
	}

	/**
	 * This annoation is used for thr Login to the Application::
	 * 
	 * @throws SQLException
	 */
	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void ConfigBM() throws SQLException, IOException {

		System.out.println("Login to The Applicatin");
	}

	/**
	 * This annoation is used for the DataBase Connection close, Report BackUp::
	 * 
	 * @throws SQLException
	 */
	@AfterSuite(groups = { "Smoke", "Regression" })
	public void ConfigAS() throws SQLException {
		System.out.println("DataBase Connection close, Report BackUp");
	}

	@AfterMethod(groups = { "Smoke", "Regression" })
	/**
	 * This annoation is used for the LogOut to the Application::
	 * 
	 * @throws SQLException
	 */
	public void ConfigAM() throws SQLException {
		System.out.println("LogOut to the Application");

	}

	/**
	 * This annoation is used for the Close The Browser::
	 * 
	 * @throws SQLException
	 */
	@AfterClass(groups = { "Smoke", "Regression" })
	public void ConfigAC() throws SQLException {
		System.out.println("Browser Close");
		driver.quit();

	}

}

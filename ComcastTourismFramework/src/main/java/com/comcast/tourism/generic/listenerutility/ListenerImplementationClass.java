package com.comcast.tourism.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.tourism.generic.basetest.BaseClass;

/**
 * listner class to take  capture run time event of the Test Scripts and it is the
 * important feature which is provided by the testNg
 * @author Rohit
 */

public class ListenerImplementationClass implements ITestListener, ISuiteListener {
	/**
	 * Made this public Accessible
	 * @author Rohit
	 */
	public ExtentReports report;
	ExtentTest test;

	@Override
	/**
	 * This  start @BeforeSuite Annotation of the BaseClass to set Up The Environment of the Report
	 * @author Rohit
	 */
	public void onStart(ISuite Suite) 
	{
		System.out.println("Report Configuration");
		String Time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html" + "_" + Time);

		spark.config().setDocumentTitle("CRM APPLICATION");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("WINDOW", "OS");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "10.2.2");
	}

	/**
	 * This  start before @AfterSuite Annotation  to save the Report
	 * @author Rohit
	 */
	@Override
	public void onFinish(ISuite Suite) {
		System.out.println("REport BackUp");
		report.flush();

	}
	/**
	 * This  start before  @BeforeMethod  annotation to capture Name of the TestScipts 
	 * at run time to provided in the report
	 * @author Rohit
	 */
	@Override
	public void onTestStart(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getMethodName() + "STARTED");
		test = report.createTest(result.getMethod().getMethodName());
		ObjectUtilityClass.setTest(test);

	}
	/**
	 * This  start work when any test Case Pass
	 * @author Rohit
	 */
	@Override
	public void onTestSuccess(ITestResult Result) {

		test.log(Status.PASS, "TEST HAS BEEN PASS");

	}
	/**
	 * This  start work when any test Script  Fail and it will take The Screenshot of that test Script
	 * @author Rohit
	 */

	@Override
	public void onTestFailure(ITestResult Result) {


		String MethodName = Result.getMethod().getMethodName();
		String Time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot tks = (TakesScreenshot) BaseClass.Sdriver;
		String path = tks.getScreenshotAs(OutputType.BASE64);
         test.addScreenCaptureFromBase64String(path, MethodName + " " + Time);
		test.log(Status.FAIL, "Test has Been Fail");
	}
/**
 * This will start when any Test Scripts get Fail
 * @author Rohit
 */
	@Override
	public void onTestSkipped(ITestResult Result) {

		test.log(Status.SKIP, "Test got Skip::");
	}

}

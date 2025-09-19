 package com.comcast.tourismtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.tourism.generic.basetest.BaseClass;
import com.comcast.tourism.generic.fileUtility.ExcelFileUitlityFile;
import com.comcast.tourism.generic.fileUtility.PropertyFileUtility;
import com.comcast.tourism.generic.javaUtility.JavaUtility;
import com.comcast.tourism.generic.objectrepositoryUtility.SignUp;
import com.comcast.tourism.generic.webdriverutility.WebDriverUtility;
/**
 * This class is responsible for .Sign UP as new  User.
 * <
 * It extends the {BaseClass}, which contains the basic/common functionality
 * needed for the framework.
 */
@Listeners(com.comcast.tourism.generic.listenerutility.ListenerImplementationClass.class)
public class SignUpAsNewUserTest  extends BaseClass {
	
	@Test(groups="Smoke")
	public void signUpTest() throws EncryptedDocumentException, IOException, InterruptedException{
		JavaUtility jv=new JavaUtility();
		
		
		
		 PropertyFileUtility file = new PropertyFileUtility();
	        String url = file.getDataFromPropertyFiles("url");


		ExcelFileUitlityFile excel=new ExcelFileUitlityFile();
		String FullName=excel.getDataFromexcelFile("User", 1, 0);
		String MobileNumber=excel.getDataFromexcelFile("User", 1, 1);
		String Email=excel.getDataFromexcelFile("User", 1, 2)+jv.getRandomNumber();
		String Password=excel.getDataFromexcelFile("User", 1, 2);
		
WebDriver driver=new ChromeDriver();
		WebDriverUtility wb=new WebDriverUtility();
	 wb.windowMaximize(driver);
    wb.toLoadPage(driver);
   SignUp hm=new SignUp(driver);
		hm.loginASnewUser(url, FullName, MobileNumber, Email, Password);

		String header=driver.findElement(By.xpath("//h4[text()='  Info successfully submited ']")).toString();
			if(header.contains("  Info successfully submited "))
			{
				System.out.println("New UserAccount Created::");
			}
			else
			{
				System.out.println("New UserAccount is not  Created::");	
			}



}
}

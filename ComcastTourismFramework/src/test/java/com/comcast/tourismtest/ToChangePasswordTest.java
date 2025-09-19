package com.comcast.tourismtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.tourism.generic.basetest.BaseClass;
import com.comcast.tourism.generic.fileUtility.ExcelFileUitlityFile;
import com.comcast.tourism.generic.fileUtility.PropertyFileUtility;
import com.comcast.tourism.generic.javaUtility.JavaUtility;
import com.comcast.tourism.generic.objectrepositoryUtility.ChangePassword;
import com.comcast.tourism.generic.objectrepositoryUtility.SignIn;
import com.comcast.tourism.generic.objectrepositoryUtility.SignUp;
import com.comcast.tourism.generic.webdriverutility.WebDriverUtility;
/**
 * This class is responsible for ..To Change Password
 * <
 * It extends the {BaseClass}, which contains the basic/common functionality
 * needed for the framework.
 */
@Listeners(com.comcast.tourism.generic.listenerutility.ListenerImplementationClass.class)
public class ToChangePasswordTest extends BaseClass {
	@Test(groups = "Regression")
	
	/**
	 * this @Test contains bussines method to To Change Password
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void changePasswordTest() throws EncryptedDocumentException, IOException, InterruptedException {
		JavaUtility jv = new JavaUtility();

		PropertyFileUtility file = new PropertyFileUtility();
		String url = file.getDataFromPropertyFiles("url");

		ExcelFileUitlityFile excel = new ExcelFileUitlityFile();
		String FullName = excel.getDataFromexcelFile("User", 1, 0);
		String MobileNumber = excel.getDataFromexcelFile("User", 1, 1);
		String Email = excel.getDataFromexcelFile("User", 1, 2) + jv.getRandomNumber();
		String Password = excel.getDataFromexcelFile("User", 1, 2);
		String NewwPassword = excel.getDataFromexcelFile("User", 1, 4);

		WebDriverUtility wb = new WebDriverUtility();
		wb.windowMaximize(driver);
		wb.toLoadPage(driver);
		SignUp hm = new SignUp(driver);
		hm.loginASnewUser(url, FullName, MobileNumber, Email, Password);

		String header = driver.findElement(By.xpath("//h4[text()='  Info successfully submited ']")).toString();
		System.out.println(header);
		if (header.contains("  Info successfully submited ")) {
			System.out.println("New UserAccount Created::");
		} else {
			System.out.println("New UserAccount is not  Created::");
		}

		SignIn sign = new SignIn(driver);
		sign.loginAsExistingUser(Email, Password);
		String Userheader = driver.findElement(By.xpath("//li[text()='" + Email + "']")).toString();

		if (Userheader.contains(Email)) {
			System.out.println("Existing  UserAccount Login:");
		} else {
			System.out.println("Existing  UserAccount not  Login:");
		}

		ChangePassword change = new ChangePassword(driver);
		change.changePasssword(Password, NewwPassword, NewwPassword);

		String ChangeHeader = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if (ChangeHeader.contains(":Your Password succesfully changed")) {
			System.out.println("SuccesFullY Password Changed");
		} else {
			{
				System.out.println("SuccesFullY  Not Password Changed::");
			}
		}

	}
}
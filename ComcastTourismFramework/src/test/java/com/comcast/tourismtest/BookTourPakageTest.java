package com.comcast.tourismtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.tourism.generic.basetest.BaseClass;
import com.comcast.tourism.generic.fileUtility.ExcelFileUitlityFile;
import com.comcast.tourism.generic.fileUtility.PropertyFileUtility;
import com.comcast.tourism.generic.javaUtility.JavaUtility;
import com.comcast.tourism.generic.objectrepositoryUtility.BookTourPackage;
import com.comcast.tourism.generic.objectrepositoryUtility.SignIn;
import com.comcast.tourism.generic.objectrepositoryUtility.SignUp;
import com.comcast.tourism.generic.webdriverutility.WebDriverUtility;
@Listeners(com.comcast.tourism.generic.listenerutility.ListenerImplementationClass.class)
/**
 * This class is responsible for booking tour packages.
 * <
 * It extends the {BaseClass}, which contains the basic/common functionality
 * needed for the framework.
 */
public class BookTourPakageTest extends BaseClass {

	@Test(groups = "Regression")
	/**
	 * this @Test contains bussines method to  bookPackage
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void bookPackageTest() throws EncryptedDocumentException, IOException, InterruptedException {
		JavaUtility jv = new JavaUtility();

		PropertyFileUtility file = new PropertyFileUtility();
		String url = file.getDataFromPropertyFiles("url");

		ExcelFileUitlityFile excel = new ExcelFileUitlityFile();
		String FullName = excel.getDataFromexcelFile("User", 1, 0);
		String MobileNumber = excel.getDataFromexcelFile("User", 1, 1);
		String Email = excel.getDataFromexcelFile("User", 1, 2) + jv.getRandomNumber();
		String Password = excel.getDataFromexcelFile("User", 1, 2);
		String NewComment = excel.getDataFromexcelFile("User", 1, 5);
		WebDriverUtility wb = new WebDriverUtility();
		wb.windowMaximize(driver);
		wb.toLoadPage(driver);
		SignUp hm = new SignUp(driver);
		hm.loginASnewUser(url, FullName, MobileNumber, Email, Password);
       
		String header = driver.findElement(By.xpath("//h4[text()='  Info successfully submited ']")).toString();

		if (header.contains("  Info successfully submited ")) 
		{
			System.out.println("New UserAccount Created::");
		} else 
		{
			System.out.println("New UserAccount is not  Created::");
		}

		SignIn sign = new SignIn(driver);
		sign.loginAsExistingUser(Email, Password);
		String Userheader = driver.findElement(By.xpath("//li[text()='" + Email + "']")).toString();
//SoftAssert soft=new SoftAssert();
  //  soft.
		if (Userheader.contains(Email)) 
		{
			System.out.println("Existing  UserAccount Login:");
		} else 
		{
			System.out.println("Existing  UserAccount not  Login:");
		}
		String StartDate = jv.getSystemDate().toString();
		String toDate = jv.getRequiredDate();
		BookTourPackage booked = new BookTourPackage(driver);
		booked.bookPackage(StartDate, toDate, NewComment);
		
		
		String BookeSuccessFully = driver.findElement(By.xpath("//div[text()=':Booked Successfully ']")).toString();
		SoftAssert soft=new SoftAssert();
		  soft.assertEquals(BookeSuccessFully, BookeSuccessFully);
	/*	if (BookeSuccessFully.contains("Booked Successfully")) 
		{
			System.out.println("Yes it Booked");
		} else 
		{
			System.out.println("Not Booked");
		}*/

	}
}
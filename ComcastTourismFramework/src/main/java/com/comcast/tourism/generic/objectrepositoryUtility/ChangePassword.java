package com.comcast.tourism.generic.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author rohit
 * This is the POM Class of  The  WebElement for the Change Password Page
 */
public class ChangePassword {
	WebDriver driver;

	public ChangePassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Change Password")
	private WebElement ChangePassword;

	@FindBy(xpath = "//input[@placeholder='Current Password']")
	private WebElement Currentpassword;

	@FindBy(id = "newpassword")
	private WebElement NewPassword;

	@FindBy(id = "confirmpassword")
	private WebElement ConfirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement ChangeButton;

	@FindBy(linkText = "/ Logout")
	private WebElement UserLogout;

	public WebElement getChangePassword() {
		return ChangePassword;
	}

	public WebElement getCurrentpassword() {
		return Currentpassword;
	}

	public WebElement getNewPassword() {
		return NewPassword;
	}

	public WebElement getConfirmPassword() {
		return ConfirmPassword;
	}

	public WebElement getUserLogout() {
		return UserLogout;
	}

	public WebElement getChangeButton() {
		return ChangeButton;
	}

	public void changePasssword(String current, String newPassord, String confirmPassword) {
		ChangePassword.click();
		Currentpassword.sendKeys(current);
		NewPassword.sendKeys(newPassord);
		ConfirmPassword.sendKeys(confirmPassword);
		ChangeButton.click();

	}

}
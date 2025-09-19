package com.comcast.tourism.generic.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rohit
 * This is the POM Class of  The  WebElement for the Admin Sign IN page
 */
public class SignIn {
	WebDriver driver;

	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "/ Sign In")
	private WebElement SignIn;

	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement ExistingEmail;

	@FindBy(id = "password")
	private WebElement ExistingPassword;

	public WebElement getSignIn() {
		return SignIn;
	}

	public WebElement getExistingEmail() {
		return ExistingEmail;
	}

	public WebElement getExistingPassword() {
		return ExistingPassword;
	}

	@FindBy(name = "signin")
	private WebElement signInButton;

	public WebElement signInButton() {
		return signInButton;
	}

	@FindBy(linkText = "/ Logout")
	private WebElement UserLogout;

	public WebElement UserLogout() {
		return UserLogout;
	}
	/**
	 * @author rohit
	 * This is the Bussiness method for the  of  existing user to login to the Aplication
	 */
	public void loginAsExistingUser(String Email, String Pass) {
		// driver.get(url);
		SignIn.click();
		ExistingEmail.sendKeys(Email);
		ExistingPassword.sendKeys(Pass);
		signInButton.click();
	}

}

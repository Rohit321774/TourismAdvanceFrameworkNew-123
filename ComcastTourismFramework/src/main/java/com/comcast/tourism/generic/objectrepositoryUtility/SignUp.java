package com.comcast.tourism.generic.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author rohit
 * This is the POM Class of  The  WebElement for the New User to login  in the application
 */
public class SignUp {

	WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign Up")
	private WebElement Signup;

	@FindBy(name = "fname")
	private WebElement FullUserName;

	@FindBy(name = "mobilenumber")
	private WebElement Mobilenumber;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(id = "submit")
	private WebElement createButton;

	public WebElement getSignUp() {
		return Signup;
	}

	public WebElement getFullUserName() {
		return FullUserName;
	}

	public WebElement getMobileNumber1() {
		return Mobilenumber;
	}

	public WebElement getEmail1() {
		return email;
	}

	public WebElement getPassword1() {
		return password;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	@FindBy(linkText = "/ Sign In")
	private WebElement SignIn;
	/**
	 * @author rohit
	 * This is the POM business New User to login  in the application
	 */
	public void loginASnewUser(String url, String FullName, String MobileNumber, String Email, String Password)
			throws InterruptedException {
		driver.get(url);
		Signup.click();
		FullUserName.sendKeys(FullName);
		Mobilenumber.sendKeys(MobileNumber);
		email.sendKeys(Email);
		password.sendKeys(Password);
		createButton.click();
		Thread.sleep(10);

	}

}

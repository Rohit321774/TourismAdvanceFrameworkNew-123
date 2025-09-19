package com.comcast.tourism.generic.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rohit This is the POM class of The webElement for the admin HomePage
 */
public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign Up")
	private WebElement Signup;

	@FindBy(linkText = "Admin Login")
	private WebElement adminLink;

	public WebElement getSignUp() {
		return Signup;
	}

	@FindBy(linkText = "/ Sign In")
	private WebElement SignIn;

	@FindBy(linkText = "Tour Packages")
	private WebElement tourpackagelink;

	@FindBy(linkText = "Privacy Policy")
	private WebElement PrivacyLink;

	@FindBy(linkText = "Terms Of Use")
	private WebElement TermsOfUselink;

	public WebElement getTourpackagelink() {
		return tourpackagelink;
	}

	public WebElement getTermsOfUselink() {
		return TermsOfUselink;
	}

	@FindBy(xpath = "Terms")
	private WebElement Enquiry;

}

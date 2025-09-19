package com.comcast.tourism.generic.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author rohit
 * This is the POM Class of  The  WebElement for the admin Login page
 */
public class AdminLogin {
	/**@author rohit
	 * Intialization of the WebElement By using PageFactory.inItElement
	 */
	 WebDriver driver;
// Constructor
	    public AdminLogin(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    

	  @FindBy(linkText = "Admin Login")
	    private WebElement adminLoginLink;

	    @FindBy(name = "username")
	    private WebElement adminUsername;

	    @FindBy(name = "password")
	    private WebElement adminPassword;

	    @FindBy(name = "login")
	    private WebElement adminLoginButton;

	    @FindBy(xpath = "//i[@class='fa fa-angle-down']")
	    private WebElement adminLogoutImage;

	    @FindBy(linkText = "Logout")
	    private WebElement adminLogout;
	    
	  @FindBy(linkText = "Back to home")
	   private WebElement adminBackToHomepage;
	    


      public WebElement getAdminBackToHomepage() {
		return adminBackToHomepage;
	}

	  public WebElement getAdminLoginLink() 
		{
			return adminLoginLink;
		}

        public WebElement getAdminUsername()
		{
			return adminUsername;
		}

        public WebElement getAdminPassword()
		{
			return adminPassword;
		}

       public WebElement getAdminLoginButton()
		{
			return adminLoginButton;
		}
      
		public WebElement getAdminLogoutImage() 
		{
			return adminLogoutImage;
		}

		public WebElement getAdminLogout() 
		{
			return adminLogout;
		}
		/**
		 * This business method for the admin to login the application
		 * @author rohit
		 * @param url
		 * @param username
		 * @param password
		 */
		public void AdminLoginToApplication(String url,String username,String password)
		{   driver.get(url);
		    adminLoginLink.click();
			adminUsername.sendKeys(username);
			adminPassword.sendKeys(password);
			adminLoginButton.click();
			
		}
		/**
		 * This business method for the admin to Logout he application
		 * @author rohit
		 */
		public void AdminLogoutToApplication()
		{
			adminLogoutImage.click();
			adminLogout.click();
			adminBackToHomepage.click();
			driver.quit();
		}

}
	


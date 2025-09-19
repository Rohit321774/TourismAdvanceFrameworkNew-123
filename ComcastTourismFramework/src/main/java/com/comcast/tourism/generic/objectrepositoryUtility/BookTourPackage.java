package com.comcast.tourism.generic.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author rohit
 * This is Pom Class for the which contains  Weblement for book tour package
 * 
 */
public class BookTourPackage {
	WebDriver driver;

    public BookTourPackage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

@FindBy(linkText = "Details")
private WebElement Detail;

@FindBy(xpath = "//input[@name='fromdate']")
private WebElement FormDate;

@FindBy(xpath = "//input[@name='todate']")
private WebElement toDate;


@FindBy(name = "comment")
private WebElement comment;

@FindBy(xpath = "//button[text()='Book']")
private WebElement Book;

public WebElement getDetail() {
	return Detail;
}

public WebElement getFormDate() {
	return FormDate;
}

public WebElement getToDate() {
	return toDate;
}

public WebElement getComment() {
	return comment;
}

public WebElement getBook() {
	return Book;
}

public void bookPackage(String StartDate,String tooDate ,String NComment) 
{ 
	Detail.click();
	FormDate.sendKeys(StartDate);
	toDate.sendKeys(tooDate);
	toDate.click();
	comment.sendKeys(NComment);
	Book.click();
}

}

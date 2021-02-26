package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewApplication 
{
	public CreateNewApplication(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Web']")
    private WebElement webapp;
	
	@FindBy(xpath="//div[contains(text(),'Next')]")
    private WebElement nextapp;
	
	@FindBy(xpath="//div[text()='Name:']/..//input")
    private WebElement appname;
	
	@FindBy(xpath="//input[contains(@title,'http:// or https:// is required')]")
    private WebElement appurl;
	
	@FindBy(xpath="//div[text()='Finish']")
    private WebElement finish;

	public WebElement getWebapp() {
		return webapp;
	}

	public WebElement getNextapp() {
		return nextapp;
	}

	public WebElement getAppname() {
		return appname;
	}

	public WebElement getAppurl() {
		return appurl;
	}

	public WebElement getFinish() {
		return finish;
	}
	
	

}

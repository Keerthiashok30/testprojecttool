package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{

	public Login(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//input[@id='username']")
	    private WebElement usn;
	 
	 @FindBy(xpath="//input[@id='password']")
	    private WebElement pwd;
	 
	 @FindBy(name="login")
	    private WebElement login;

	public WebElement getUsn() {
		return usn;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLogin() {
		return login;
	}
	 
	public void logincredentials(String username , String password)
	{             
		usn.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}
	    
}

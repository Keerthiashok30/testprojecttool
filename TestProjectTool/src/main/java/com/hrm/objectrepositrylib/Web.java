package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author keerthi
 *
 */
public class Web 
{
	WebDriver driver;
	public Web(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Login")
    private WebElement loginweb;

	public WebElement getLoginweb() {
		return loginweb;
	}
	
	
}

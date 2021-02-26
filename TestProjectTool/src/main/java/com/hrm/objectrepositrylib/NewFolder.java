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
public class NewFolder
{
	
	public NewFolder(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div/span[contains(text(),'Name')]/../../input")
    private WebElement name;
	
	@FindBy(xpath="//div[contains(@class,'tp-mbw-nav nav-right')]")
	private WebElement add;
	
	public WebElement getName() {
		return name;
	}

	public WebElement getAdd() {
		return add;
	}
	
	
	
}

package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPopup
{
	public EditPopup(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='SAVE & EXIT']")
    private WebElement saveandexit;

	public WebElement getSaveandexit() {
		return saveandexit;
	}
	
	

}

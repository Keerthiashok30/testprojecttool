package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAParameter
{
	public AddAParameter(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Name']/..//../input")
    private WebElement paramname;
	
	@FindBy(xpath="//span[text()='Value']/..//../input")
    private WebElement paramvalue;

	@FindBy(xpath="//div[text()='Create']")
    private WebElement paramcreate;

	public WebElement getParamname() {
		return paramname;
	}

	public WebElement getParamvalue() {
		return paramvalue;
	}

	public WebElement getParamcreate() {
		return paramcreate;
	}
	
	
	
}

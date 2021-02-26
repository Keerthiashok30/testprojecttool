package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddANewDataSource
{
	public AddANewDataSource(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Name']/../..//input")
    private WebElement datasourcename;

	@FindBy(xpath="//span[text()='Description']/../..//input")
    private WebElement datasourcedescription;
	
	@FindBy(xpath="//div[contains(@class,'tp-drop-zone ng-isolate-scope')]")
    private WebElement uploadfile;

	public WebElement getDatasourcename() {
		return datasourcename;
	}

	public WebElement getDatasourcedescription() {
		return datasourcedescription;
	}

	public WebElement getUploadfile() {
		return uploadfile;
	}
	
}

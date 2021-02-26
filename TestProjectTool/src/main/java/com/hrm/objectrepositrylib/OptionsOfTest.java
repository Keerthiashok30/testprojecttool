package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsOfTest
{
	public OptionsOfTest(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Data sources']")
    private WebElement datasource;
	
	@FindBy(xpath="//div[text()='Add a new data source']")
    private WebElement adddatasource;

	public WebElement getDatasource() {
		return datasource;
	}

	public WebElement getAdddatasource() {
		return adddatasource;
	}

}

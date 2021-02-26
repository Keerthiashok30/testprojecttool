package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateANewProject 
{

	public CreateANewProject(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div/span[text()='Name']/../input")
    private WebElement nameproject;
	
	@FindBy(xpath="//div[contains(@class,'tp-mbw-nav-button ng-binding ng-scope blue')]")
    private WebElement createproject;

	public WebElement getNameproject() {
		return nameproject;
	}

	public WebElement getCreateproject() {
		return createproject;
	}
	
	
}

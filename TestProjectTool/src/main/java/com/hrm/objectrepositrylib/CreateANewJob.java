package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateANewJob
{
	public CreateANewJob(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Web')]")
    private WebElement webjob;
	
	@FindBy(xpath="//div[contains(text(),'Next')]")
    private WebElement nextjob;
	
	@FindBy(xpath="//div[text()='Name']//..//..//input")
    private WebElement namejob;
	
	@FindBy(xpath="//div[@title='Chrome 88.0.4324.190']")
    private WebElement agentbrowser;
	
	@FindBy(xpath="//div[contains(@class,'tp-mbw-nav-button ng-binding ng-scope blue')]")
    private WebElement createjob;

	public WebElement getWebjob() {
		return webjob;
	}

	public WebElement getNextjob() {
		return nextjob;
	}

	public WebElement getNamejob() {
		return namejob;
	}

	public WebElement getAgentbrowser() {
		return agentbrowser;
	}

	public WebElement getCreatejob() {
		return createjob;
	}
	
}

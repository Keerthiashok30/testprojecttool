package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.objectrepositrylib.NewFolder;

public class Home 
{
	public WebDriver driver =null;
	NewFolder newfold=new NewFolder(driver);
	
	
	@FindBy(xpath="//span[contains(text(),'New Folder')]")
    private WebElement newfolder;
	
	@FindBy(xpath="//div[text()='New Test']")
    private WebElement newtest;
	
	public WebElement getNewtest() {
		return newtest;
	}


	@FindBy(xpath="//span[contains(text(),'Up to root')]")
    private WebElement uptoroot;
	
	@FindBy(xpath="//div[contains(text(),'Create a test')]")
    private WebElement createtest;
	
	@FindBy(xpath="//div[contains(text(),'New Job')]")
    private WebElement createjob;
	
	@FindBy(xpath="//div[contains(text(),'Add a job')]")
    private WebElement addjob;
	
	@FindBy(xpath="//span[text()='Parameters']")
    private WebElement parameter;
	
	@FindBy(xpath="//div[@class='emc-button']")
    private WebElement addparameter;
	
	@FindBy(xpath="//div[text()='Add an application']")
    private WebElement addapplication;
	
	public WebElement getParameter() {
		return parameter;
	}
	


	public WebElement getAddapplication() {
		return addapplication;
	}



	public WebElement getAddparameter() {
		return addparameter;
	}


	public WebElement getAddjob() {
		return addjob;
	}


	@FindBy(xpath="//div[contains(@title,'Sample Login Test')]")
    private WebElement choosetest;
	
	@FindBy(xpath="//div[contains(text(),'Drop your first test here')]")
    private WebElement droptest;
	
	@FindBy(xpath="//a[contains(text(),'Reports')]")
    private WebElement report;
	
	@FindBy(xpath="//div[@title='Data source is not attached']")
    private WebElement datasource;
	
	@FindBy(xpath="//div[text()='My Projects']")
    private WebElement projectarrow;
	
	@FindBy(xpath="//div[@class='refresh-job-tests-icon']")
    private WebElement refreshbuttton;
	
	@FindBy(xpath="//div[@title='More ...']")
    private WebElement morebutton;
	
	@FindBy(xpath="//div[text()='Reports']")
    private WebElement reportmore;
	
	@FindBy(xpath="//span[text()='Applications']")
    private WebElement application;
	
	public WebElement getReportmore() {
		return reportmore;
	}


	public WebElement getApplication() {
		return application;
	}


	public WebElement getMorebutton() {
		return morebutton;
	}


	public WebElement getRefreshbuttton() {
		return refreshbuttton;
	}


	public WebElement getDatasource() {
		return datasource;
	}


	@FindBy(xpath="//div[@class='new-project-text']")
    private WebElement createproject;
	
	
	public WebElement getCreateproject() {
		return createproject;
	}


	public WebElement getProjectarrow() {
		return projectarrow;
	}


	public WebElement getDroptest() {
		return droptest;
	}


	public WebElement getReport() {
		return report;
	}


	public WebElement getChoosetest() {
		return choosetest;
	}


	public WebElement getCreatejob() {
		return createjob;
	}


	public WebElement getCreatetest() {
		return createtest;
	}


	public WebElement getUptoroot() {
		return uptoroot;
	}


	public Home(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getNewfolder() {
		return newfolder;
	}
	

}

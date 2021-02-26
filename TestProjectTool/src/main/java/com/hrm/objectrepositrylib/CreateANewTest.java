package com.hrm.objectrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateANewTest
{
	public CreateANewTest(WebDriver driver) 
	{             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Web')]/../div[contains(@class,'ctw-step1-body-type-icon-wrapper')]")
    private WebElement web;
	
	@FindBy(xpath="//div[contains(text(),'Next')]")
    private WebElement next;
	
	@FindBy(xpath="//input[contains(@title,'Test Name')]")
    private WebElement name;
	
	@FindBy(xpath="//div[contains(text(),'Web applications')]")
    private WebElement webapp;
	
	@FindBy(xpath="//div[text()='Add a new application for testing']")
    private WebElement chooseapp;
	
	@FindBy(xpath="//div[text()='Name:']/..//input")
    private WebElement appname;
	
	@FindBy(xpath="//input[contains(@title,'http:// or https:// is required')]")
    private WebElement appurl;
	
	@FindBy(xpath="//span[contains(text(),'Orange HRM')]")
    private WebElement orangeapp;
	
	@FindBy(xpath="//div[text()='Finish']")
    private WebElement finish;
	
	@FindBy(xpath="//div[contains(text(),'Start editing')]")
    private WebElement startediting;
	
	public WebElement getAppname() {
		return appname;
	}

	public WebElement getStartediting() {
		return startediting;
	}

	public WebElement getFinish() {
		return finish;
	}

	@FindBy(xpath="//div[contains(text(),'Blank Test')]")
    private WebElement blanktest;
	
	@FindBy(xpath="//div[contains(text(),'Edit')]")
    private WebElement edit;
	
	public WebElement getChooseapp() {
		return chooseapp;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getAppurl() {
		return appurl;
	}

	@FindBy(xpath="//div[contains(@class,'tp-mbw-nav nav-right')]")
    private WebElement create;

	public WebElement getWeb() {
		return web;
	}

	public WebElement getNext() {
		return next;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getWebapp() {
		return webapp;
	}

	public WebElement getOrangeapp() {
		return orangeapp;
	}

	public WebElement getBlanktest() {
		return blanktest;
	}

	public WebElement getCreate() {
		return create;
	}
	
	
}

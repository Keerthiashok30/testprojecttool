package com.hrm.gnericlib;

import java.sql.SQLException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.hrm.objectrepositrylib.Login;
import com.hrm.objectrepositrylib.Web;



/**
 * 
 * @author keerthi
 *
 */
public class BaseClass 
{
	public FileUtility flib=new FileUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	
	public JavaUtility javaLib = new JavaUtility();
	public ExcelUtility excelLib = new ExcelUtility();
	public Web webpage;
	public Login loginPage;
	String BROWSER =null;
	public WebDriver driver =null;
	
	@BeforeSuite
	public void configBeforeSuite() 
	{
		
	}
	
	@BeforeTest
	public void configBeforeTest()
	{
		
	}
	
	

	
	/**
	 * Launching the browser in normal mode and entering the url 
	 * @throws Throwable
	 */
	@BeforeClass
	public void configBeforeClass() throws Throwable 
	{
		BROWSER = flib.getPropertyKeyValue("browser");
	}
	
	/**
	 * login to testproject tool application
	 * @throws Throwable 
	 */
	@BeforeMethod
	public void configBeforeMethod() throws Throwable 
	{
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(flib.getPropertyKeyValue("url"));
		webpage=new Web(driver);
		webpage.getLoginweb().click();
		
		//webpage to loginpage
				Set<String> set = driver.getWindowHandles();
				for(String win:set)
				{
					driver.switchTo().window(win);
					String title = driver.getTitle();
					System.out.println(title);
				}
				
		loginPage=new Login(driver);
		wlib.waitForHTMLDOM(driver);
		loginPage.logincredentials(flib.getPropertyKeyValue("username"), flib.getPropertyKeyValue("password"));
	}
	
	
	/**
	 * logout from testproject tool application
	 */
	@AfterMethod
	public void configAfterMethod()
	{
		
	}
	
	/**
	 * close the browser
	 */
	@AfterClass
	public void configAfterClass() 
	{
		driver.quit();
	}
	
	@AfterTest
	public void configAfterTest()
	{
		
	}
	
	
	@AfterSuite
	public void configAfterSuite()
	{
		
		System.out.println("flush extent report");
		
	}

}

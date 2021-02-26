package com.hrm.gnericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





/**
 * 
 * @author Keerthi
 *
 */
public class WebdriverUtility
{

	/**
	 *  used to wait for Element to be clickable in GUI  & check for the elemnet for every 500 milisecond , 
	 * @param driver
	 * @param elemnet
	 */
	public void waitforElementToBeClickable(WebDriver driver , WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, IConstant.explicitlyWaitWiat);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 *  used to wait for visibility Of Element Locatede in GUI  & check for the elemnet for every 500 milisecond , 
	 * @param driver
	 * @param elemnet
	 */
	public void waitforvisibilityOfElementLocated(WebDriver driver , By element) {
		 WebDriverWait wait = new WebDriverWait(driver, IConstant.explicitlyWaitWiat);
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}
	
	/**
	 * used to wait for expected element in GUI
	 * @param element
	 * @throws Throwable
	 */
	public void waitforElement( WebElement element) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   element.isDisplayed();
			     break;
			   }catch (Throwable e) {
				Thread.sleep(500);
				count++;
			   }
	        }
	}
	
	/**
	 * used to wait for expected element in GUI based on Xpath
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebDriver driver , WebElement element) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   element.click();
			     break;
			   }catch (Throwable e) {
				 Thread.sleep(500);
				 count++;
			   }
	        }
	}
	
	/**
	 * wait for DOM document to be load before finding any elemnet in GUI
	 * @param driver
	 */
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyWiat, TimeUnit.SECONDS);
		
	}
	
	/**
	 * used to take mouse cursor on expected element on the browser
	 * @param driver
	 * @param element
	 */
	public void moveToExpectedElemnet(WebDriver driver , WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void swictToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
   public void swictToFrame(WebDriver driver , WebElement element) {
	   driver.switchTo().frame(element);
	}
   
   public void swictToFrame(WebDriver driver , String id, String name) {
	   WebElement fwb;
	     if(id!=null) {
	    	 driver.switchTo().frame(id);
	     }else {
	    	 driver.switchTo().frame(name);
	     }
	   
	}
  
}

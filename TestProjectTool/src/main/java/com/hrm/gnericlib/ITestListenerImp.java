package com.hrm.gnericlib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

/**
 * 
 * @author Keerthi
 *
 */
public class ITestListenerImp implements ITestListener
{
	ExtentReports extreport;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		test=extreport.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"TestScript passed");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver=null;
		test.log(Status.FAIL, result.getMethod().getMethodName()+"testScript failed");
		EventFiringWebDriver event =new EventFiringWebDriver(driver);
		File src=event.getScreenshotAs(OutputType.FILE);
		String screenshotpath="./screenshot/"+result.getMethod().getMethodName()+".png";
		File des=new File(screenshotpath);
		try
		{
		Files.copy(src, des);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"TestScript skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
      ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File("./report.html"));
      reporter.config().setDocumentTitle("Extent Report");
      reporter.config().setTheme(Theme.DARK);
      reporter.config().setReportName("Demo scripts");
      
      extreport=new ExtentReports();
      extreport.attachReporter(reporter);
      extreport.setSystemInfo("browser", "http://localhost:8888");
      extreport.setSystemInfo("OS", "window 10");
      extreport.setSystemInfo("ReporterNAme", "Keerthi");

		
	}

	public void onFinish(ITestContext context) {
		extreport.flush();
		
	}


}

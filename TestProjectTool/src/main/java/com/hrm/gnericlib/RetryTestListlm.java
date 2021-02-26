package com.hrm.gnericlib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestListlm implements IRetryAnalyzer
{

	 int counter = 1;
	 int retryLimit = 3;
	 
	public boolean retry(ITestResult result) {
		if(counter < retryLimit)
		 {
		 counter++;
		 return true;
		 }
		 return false;
                                                        
	}
}

package com.bellatrix.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerDemo implements ITestListener{
	public void onTestFailure(ITestResult result) { //screenShot ka code utility me hai
	
		//get fileName = result.getMethod().getMethodName();
		Screenshot  screenshot = new Screenshot();
		
		
			try {
				screenshot.captureFullPageScreenshot(result.getMethod().getMethodName());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		
	}

}

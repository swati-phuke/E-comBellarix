package com.bellatrix.stepDefination;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bellatrix.config.Configration;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class TestBase {
	private static final Logger LOG = Logger.getLogger(TestBase.class);
	public Configration config;
	
	public static RemoteWebDriver driver;
	
	public static RemoteWebDriver  getDriver() {
		  return driver;
	  }
	@Before
	public  void SetUp() throws FileNotFoundException {
		config = new Configration();
		String browserName = config.getBrowserName();
		if(browserName==null) {
			browserName = "Chrome";
		}
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Launching default browser:Chrome");
			driver = new ChromeDriver();
		}
		driver.get(config.getAppURl());
		driver.manage().window().maximize();
	
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	

}

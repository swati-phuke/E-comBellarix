package com.bellatrix.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.bellatrix.stepDefination.TestBase;

public class WaitFor {
	static FluentWait<WebDriver> wait ;
	static {
		wait = new FluentWait<WebDriver>(TestBase.getDriver());
		wait.withTimeout(Duration.ofSeconds(60));
	}
	public static void staleElement(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
		
	}
	public static void waitMethod(WebElement webelement) {
		wait.until(ExpectedConditions.elementToBeClickable(webelement)).click();
	}

	public void implicitWait(int a) {
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	public void scrollby() {
		TestBase.driver.executeScript("window.scrollBy(0,1700)");
	}
}

package com.bellatrix.runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/resources/Feature/cartPage.feature",glue = "com.bellatrix.stepDefination",
tags = "@smoke")

public class RunnerCartPage extends AbstractTestNGCucumberTests {
	
	


}

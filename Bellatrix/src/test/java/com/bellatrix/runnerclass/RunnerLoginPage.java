package com.bellatrix.runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature/loginPage.feature",glue = "com.bellatrix.stepDefination",
tags = "@Smoke")

public class RunnerLoginPage extends AbstractTestNGCucumberTests {

}

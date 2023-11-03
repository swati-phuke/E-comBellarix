package com.bellatrix.runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature/HomePage.feature",glue = "com.bellatrix.stepDefination")
public class RunnerHomePage extends AbstractTestNGCucumberTests{

}

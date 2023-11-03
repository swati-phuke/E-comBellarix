package com.bellatrix.runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature/checkout.feature",glue = "com.bellatrix.stepDefination"
)

public class RunnerCheckout  extends AbstractTestNGCucumberTests {

}

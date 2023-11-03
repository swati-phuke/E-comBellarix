package com.api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/restApiFeature/api.feature",glue = "com.rest_api_stepdeffination",
tags = "@Smoke"
)
public class RunnerApi extends AbstractTestNGCucumberTests {

}

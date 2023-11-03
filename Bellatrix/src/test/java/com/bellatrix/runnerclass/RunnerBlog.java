package com.bellatrix.runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature/blogpage.feature",glue = "com.bellatrix.stepDefination",
tags = "@Smoke"
)
public class RunnerBlog extends AbstractTestNGCucumberTests {

}

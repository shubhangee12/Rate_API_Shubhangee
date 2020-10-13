package com.companyname.projectname.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
                 glue = "com.companyname.projectname.steps",
        plugin = {"pretty", "html:target/cucumber-reports/report.html"},
        monochrome = true
        )
public class TestRunner {

}

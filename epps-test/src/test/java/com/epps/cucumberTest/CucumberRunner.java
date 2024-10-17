package com.epps.cucumberTest;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

//@RunWith(Cucumber.class) 
//@Cucumber.Options(format = {"pretty", "html:target/cucumber"})
//
//
//public class runTest { 
//	
//	
//}
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumberFrameworkPractise", format = {
        "pretty", "html:target/cucumber-htmlreport",
"json-pretty:target/cucumber-report.json" })
public class CucumberRunner {

}
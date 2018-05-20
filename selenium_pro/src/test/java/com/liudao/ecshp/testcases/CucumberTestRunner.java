package com.liudao.ecshp.testcases;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		features = {"classpath:features"},
		glue = {"com.liudao.ecshop.steps"},
		monochrome = true,
		plugin = {"html:target/cucumber-report/html","json:target/cucumber-report/json/cucumber-report.json"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}

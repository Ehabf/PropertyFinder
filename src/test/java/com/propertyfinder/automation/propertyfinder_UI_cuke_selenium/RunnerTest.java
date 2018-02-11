package com.propertyfinder.automation.propertyfinder_UI_cuke_selenium;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty", "json:target/cucumber-report/json/cucumber.json", "html:target/cucumber-report/html/"},
		features = "src/test/resource"
		)
public class RunnerTest {

}

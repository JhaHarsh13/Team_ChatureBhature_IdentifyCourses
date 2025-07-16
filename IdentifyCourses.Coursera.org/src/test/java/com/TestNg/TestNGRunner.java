package com.TestNg;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/resources/Feature/Coursera.feature",
	glue="com.Cognizant.cucumber.steps"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	 
	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

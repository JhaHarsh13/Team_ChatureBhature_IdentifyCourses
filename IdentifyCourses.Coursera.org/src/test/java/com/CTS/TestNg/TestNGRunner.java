package com.CTS.TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
	features="src/test/resources/Feature/Coursera.feature",
	glue="com.CTS.Cucumber.Steps"
)
//@Listeners(com.CTS.TestNg.RetryListener.class)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	 
	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}
	@Test(dataProvider="scenarios", retryAnalyzer= com.CTS.TestNg.RetryAnalyzer.class)
	public void runScenario(PickleWrapper pickle, FeatureWrapper feature) {
		super.runScenario(pickle, feature);
	}
}

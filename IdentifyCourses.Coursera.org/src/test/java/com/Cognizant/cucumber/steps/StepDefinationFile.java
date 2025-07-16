package com.Cognizant.cucumber.steps;


import com.CTS.Pges.EnterprisePage;
import com.CTS.Pges.LangLearningPage;
import com.CTS.Pges.WebDevelopmentPage;

import ConfigureReader.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class StepDefinationFile {
	private WebDriver driver=new ChromeDriver();
	private WebDevelopmentPage webPage=new WebDevelopmentPage(driver);
	private LangLearningPage langPage=new LangLearningPage(driver);
	private EnterprisePage enterprisePage=new EnterprisePage(driver);
	private String baseUrl=ConfigReader.getProperty("baseUrl");
	private String webDevEntry=ConfigReader.getProperty("entry1");
	private String langLearnEntry=ConfigReader.getProperty("entry2");
	private String firstName=ConfigReader.getProperty("firstName");
	private String lastName=ConfigReader.getProperty("lastName");
	private String email=ConfigReader.getProperty("email");
	private String phoneNo=ConfigReader.getProperty("phoneNo");
	private String title=ConfigReader.getProperty("title");
	private String name=ConfigReader.getProperty("name");
	private Assertion assertion;
	
	@Given("I open the Coursera.org home page")
	public void open_CourseraOrg_Home_Page() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@When("I search Web Development")
	public void searchWebDevelopment() {
		webPage.enterElementandClickToSearchWeb(webDevEntry);
	}
	
	@And("I apply filters for English language and Beginner level")
	public void applyFilters() throws Exception{
		webPage.clickEnglish();
		webPage.clickBeginner();
	}
	@Then("I should retrieve details of the first two course cards")
	public void verifyIfableToRetrieveIfoOfFirstTwoCards() throws Exception{
		System.out.println("Entered the method");
		webPage.printingTheDesiredResult();
		driver.quit();
	}
	
	@When("I search Language Learning")
	public void searchLanguageLearning() {
		langPage.enterElementandClickToSearchLang(langLearnEntry);
	}
	
	@Then("I should retrieve all the languages")
	public void check_Validation_If_Languages_Are_Extracted_Or_Not() throws Exception{
		langPage.scrollToAndClickOnShowMore();
		langPage.printingAndWritingToExcel();	
		driver.quit();
	}
	
	@Given("I am on the Cousera.org page and I navigate to For Enterprise Page")
	public void I_am_on_the_Cousera_org_page_and_I_navigate_to_For_Enterprise_Page() throws Exception{
		driver.get(baseUrl);
		driver.manage().window().maximize();
		enterprisePage.scrollAndClickForEnterprise();
	}
	@When("I am on Enterprise page I scroll to Form")
	public void I_am_on_Enterprise_page_I_scroll_to_Form() {
		enterprisePage.scrollToForm();
	}
	@When("I fill the contact form with invalid details like firstName, lastName, email, phoneNo, title, name")
	public void enteringDataToForm() {
		enterprisePage.setValuesIntoForm(firstName, lastName, email, phoneNo, title, name);
	}
	@And("I click on submit button")
	public void clickOnSubmitButton() {
		enterprisePage.submitForm();
	}
	@Then("I should capture the error message")
	public void verifyingIfErrorMessageIsCapturedOrNot() throws Exception{
		enterprisePage.takeScreenShot();
		enterprisePage.displayErrorMessage();
		driver.quit();
	}
	
}

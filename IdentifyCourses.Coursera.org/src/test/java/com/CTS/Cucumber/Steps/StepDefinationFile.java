package com.CTS.Cucumber.Steps;


import com.CTS.ConfigureReader.ConfigReader;
import com.CTS.PageUtils.PageReloadingClass;
import com.CTS.Pages.EnterprisePage;
import com.CTS.Pages.LangLearningPage;
import com.CTS.Pages.WebDevelopmentPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class StepDefinationFile {
	private WebDriver driver=new ChromeDriver();
	private WebDevelopmentPage webPage;
	private LangLearningPage langPage;
	private EnterprisePage enterprisePage;
	private String baseUrl=ConfigReader.getProperty("baseUrl");
	private String webDevEntry=ConfigReader.getProperty("entry1");
	private String langLearnEntry=ConfigReader.getProperty("entry2");
	private String firstName=ConfigReader.getProperty("firstName");
	private String lastName=ConfigReader.getProperty("lastName");
	private String email=ConfigReader.getProperty("email");
	private String phoneNo=ConfigReader.getProperty("phoneNo");
	private String title=ConfigReader.getProperty("title");
	private String name=ConfigReader.getProperty("name");
	
	@Given("I open the Coursera.org home page and wait for it to reload")
	public void open_CourseraOrg_Home_Page() throws Exception {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		PageReloadingClass.waitForElementWithRefresh(driver, By.xpath("//*[@id='search-autocomplete-input']"), 2);
		webPage=new WebDevelopmentPage(driver);
		driver.manage().window().maximize();
	}
	
	@When("I search Web Development")
	public void searchWebDevelopment() throws Exception {
		webPage.enterElementandClickToSearchWeb(webDevEntry);
	}
	
	@And("I apply filters for English language and Beginner level")
	public void applyFilters() throws Exception{
		webPage.clickEnglish();
		webPage.clickBeginner();
	}
	@Then("I should retrieve details of the first two course cards")
	public void verifyIfableToRetrieveIfoOfFirstTwoCards() throws Exception{
		webPage.printingTheDesiredResult();
		driver.quit();
		
	}
	
	@Given("I am on the Web Development page and go back to the Coursera.org home page and wait for it to reload")
	public void navigating_to_CourseraOrg_Home_Page_again() throws Exception{
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		PageReloadingClass.waitForElementWithRefresh(driver, By.xpath("//*[@id='search-autocomplete-input']"), 2);
		driver.manage().window().maximize();
		langPage=new LangLearningPage(driver);
		
	}
	
	
	@When("I search Language Learning")
	public void searchLanguageLearning() throws Exception {
		langPage.enterElementandClickToSearchLang(langLearnEntry);
	}
	
	@Then("I should retrieve all the languages")
	public void check_Validation_If_Languages_Are_Extracted_Or_Not() throws Exception{
		langPage.scrollToAndClickOnShowMore();
		langPage.printingAndWritingToExcel();	
		driver.quit();
	}
	
	@Given("I am on the Cousera.org page and I wait for it to reload and I navigate to For Enterprise Page")
	public void I_am_on_the_Cousera_org_page_and_I_navigate_to_For_Enterprise_Page() throws Exception{
		driver.get(baseUrl);
		driver.manage().window().maximize();
		PageReloadingClass.waitForElementWithRefresh(driver, By.xpath("//a[contains(text(),'For Enterprise')]"), 2);
		driver.manage().window().maximize();
		enterprisePage=new EnterprisePage(driver);
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

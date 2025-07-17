package com.CTS.Pges;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class EnterprisePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public EnterprisePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(120));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'For Enterprise')]")
	WebElement enterpriseElementText;
	
	@FindBy(id="FirstName")
	WebElement firstNameField;
	
	@FindBy(id="LastName")
	WebElement lastNameField;
	
	@FindBy(id="Email")
	WebElement emailField;
	
	@FindBy(id="Phone")
	WebElement phoneField;
	
	@FindBy(id="rentalField9")
	WebElement organisationField;
	
	@FindBy(id="Title")
	WebElement jobTitle;
	
	@FindBy(id="Company")
	WebElement companyField;
	
	@FindBy(id="Employee_Range__c")
	WebElement companySizeField;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	WebElement needs;
	
	@FindBy(id="Country")
	WebElement countryField;
	
	@FindBy(id="State")
	WebElement stateField;
	
	@FindBy(xpath="//button[@class='mktoButton']")
	WebElement submitBtn;
	
	@FindBy(id="ValidMsgEmail")
	WebElement errorMsg;
	
	public void scrollAndClickForEnterprise() throws Exception{
		//WebElement elementToBeScrolled=wait.until(ExpectedConditions.visibilityOf(enterpriseElementText));
		WebElement enterpriseEle=wait.until(ExpectedConditions.elementToBeClickable(enterpriseElementText));
		js.executeScript("arguments[0].scrollIntoView(true);", enterpriseEle);
		js.executeScript("arguments[0].click();", enterpriseEle);
	}
	
	public void scrollToForm() {
		WebElement scrollEle=wait.until(ExpectedConditions.visibilityOf(firstNameField));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollEle);
		
	}
	
	public void setValuesIntoForm(String firstName,String lastName,String email,String phoneNo,String title,String name) {
		WebElement fNameEle=wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		
		//js.executeScript("arguments[0].value="+firstName+";", fNameEle);
		js.executeScript("arguments[0].value=arguments[1];",fNameEle, firstName);
		wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
		wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOf(phoneField)).sendKeys(phoneNo);
		Select orgDropDown=new Select(wait.until(ExpectedConditions.visibilityOf(organisationField)));
		orgDropDown.selectByValue("Business");
		wait.until(ExpectedConditions.visibilityOf(jobTitle)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOf(companyField)).sendKeys(name);
		Select sizeDropDown=new Select(wait.until(ExpectedConditions.visibilityOf(companySizeField)));
		sizeDropDown.selectByValue("501-1000");
		Select needsDropDown=new Select(wait.until(ExpectedConditions.visibilityOf(needs)));
		needsDropDown.selectByValue("Courses for myself");
		Select countryDropDown=new Select(wait.until(ExpectedConditions.visibilityOf(countryField)));
		countryDropDown.selectByValue("India");
		Select stateDropDown=new Select(wait.until(ExpectedConditions.visibilityOf(stateField)));
		stateDropDown.selectByValue("Maharashtra");		
	}
	
	public void submitForm() {
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	}
	
	public void takeScreenShot() throws Exception{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		long timeStamp=System.currentTimeMillis();
		File outFile=new File(System.getProperty("user.dir")+"//ScreenShot//Screenshot("+timeStamp+").png");
		FileUtils.copyFile(srcFile, outFile);
		System.out.println("ScreenShot taken");
	}
	public void displayErrorMessage() {
		String str=wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
		System.out.println("The error message is:" + str);
		
	}
	
	
	
	
	
	
	
}
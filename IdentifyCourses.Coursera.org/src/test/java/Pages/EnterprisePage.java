package Pages;

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
	public EnterprisePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'For Enterprise')]")
	WebElement enterpriseElementText;
	
	@FindBy(xpath="(//h2[@class='cds-119 css-13rt5ey cds-121'])[2]")
	WebElement submitFormText;
	
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
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//WebElement elementToBeScrolled=wait.until(ExpectedConditions.visibilityOf(enterpriseElementText));
		js.executeScript("arguments[0].scrollIntoView(true);", enterpriseElementText);
		enterpriseElementText.click();
	}
	
	public void scrollToForm() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", submitFormText);
		
	}
	
	public void setValuesIntoForm(String firstName,String lastName,String email,String phoneNo,String title,String name) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		phoneField.sendKeys(phoneNo);
		Select orgDropDown=new Select(organisationField);
		orgDropDown.selectByValue("Business");
		jobTitle.sendKeys(title);
		companyField.sendKeys(name);
		Select sizeDropDown=new Select(companySizeField);
		sizeDropDown.selectByValue("501-1000");
		Select needsDropDown=new Select(needs);
		needsDropDown.selectByValue("Courses for myself");
		Select countryDropDown=new Select(countryField);
		countryDropDown.selectByValue("India");
		Select stateDropDown=new Select(stateField);
		stateDropDown.selectByValue("Maharashtra");		
	}
	
	public void submitForm() {
		submitBtn.click();
	}
	
	public void takeScreenShot() throws Exception{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		long timeStamp=System.currentTimeMillis();
		File outFile=new File(System.getProperty("user.dir")+"//ScreenShot//screenshot("+timeStamp+").png");
		FileUtils.copyFile(srcFile, outFile);
		System.out.println("ScreenShot taken");
	}
	public void displayErrorMessage() {
		String str=errorMsg.getText();
		System.out.println("The error message is:" + str);
		
	}
	
	
	
	
	
	
	
}
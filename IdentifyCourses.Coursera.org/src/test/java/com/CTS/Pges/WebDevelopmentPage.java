package com.CTS.Pges;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CTS.UtilityPackage.ExcelUtils;

import ConfigureReader.ConfigReader;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WebDevelopmentPage {
	WebDriver driver;
	WebDriverWait wait;
	public WebDevelopmentPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='search-autocomplete-input']")
	WebElement inputField;
	
	
	@FindBy(xpath="//button[contains(@class,'search-button')]/*")
	WebElement searchButton;
	
	@FindBy(xpath="//*[contains(text(),'English')]")
	WebElement englishElement;
	
	@FindBy(xpath="//div[contains(@data-testid,'language:English')]/*/span/*/input")
	WebElement englishElementCheckBox;
	
	@FindBy(xpath="//span[contains(text(),'Beginner')]")
	WebElement beginnerElement;
	
	@FindBy(xpath="//div[contains(@data-testid,'productDifficultyLevel:Beginner')]/*/span/*/input")
	WebElement beginnerElementCheckBox;
	
	@FindBy(xpath="//h3[contains(@class, 'title')]")
	List <WebElement> courseNames;
	
	@FindBy(xpath="//span[@class='css-6ecy9b']")
	List <WebElement> reviewEle;
	
	@FindBy(xpath="//div[@class='cds-CommonCard-metadata']/p")
	List<WebElement> timeElements;
	
	public void enterElementandClickToSearchWeb(String entry) {
		wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(entry);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		
	}
	
	public void clickEnglish() throws Exception{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement elementToBeViewed=wait.until(ExpectedConditions.visibilityOf(englishElement));
		js.executeScript("arguments[0].scrollIntoView(true);", elementToBeViewed);
		englishElementCheckBox.click();
		
	}
	
	public void clickBeginner() throws Exception{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement elementToBeViewed=wait.until(ExpectedConditions.visibilityOf(beginnerElement));
		js.executeScript("arguments[0].scrollIntoView(true);", elementToBeViewed);
		beginnerElementCheckBox.click();
		
	}
	
	public void printingTheDesiredResult() {
		for(int i=0; i<2; i++) {
			String time=wait.until(ExpectedConditions.visibilityOfAllElements(timeElements)).get(i).getText();
			String regex="\\d+\\s*-\\s*\\d+\\s*(Months|Weeks)";
			Pattern pattern=Pattern.compile(regex);
			Matcher matcher=pattern.matcher(time);
			System.out.print("Course Names: "+wait.until(ExpectedConditions.visibilityOfAllElements(courseNames)).get(i).getText()+", ");
			System.out.print("Reviews: "+wait.until(ExpectedConditions.visibilityOfAllElements(reviewEle)).get(i).getText()+", ");
			while(matcher.find()) {
				System.out.print("Learning period: "+matcher.group()+" ");
			}
			System.out.println();
		}
	}
	
}

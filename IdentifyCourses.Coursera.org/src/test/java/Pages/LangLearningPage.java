package Pages;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConfigureReader.ConfigReader;
import UtilityFile.ExcelUtils;

public class LangLearningPage {
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl=ConfigReader.getProperty("baseUrl");
	public LangLearningPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='search-autocomplete-input']")
	WebElement inputField;
	
	@FindBy(xpath="//button[contains(@class,'search-button')]/*")
	WebElement searchButton;
	
	@FindBy(xpath="//div[contains(text(), 'Language')]")
	WebElement languageElement;
	
	@FindBy(xpath="//button[contains(@aria-label, 'Language')]/span")
	WebElement ShowMore;
	
	@FindBy(xpath="//div[contains(@data-testid,'language:')]")
	List <WebElement> listOfLanguage;
	
	public void enterElementandClickToSearchLang(String entry) {
		driver.navigate().to(baseUrl);
		wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(entry);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		
	}
	public void scrollToAndClickOnShowMore() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement elementToBeViewed=wait.until(ExpectedConditions.visibilityOf(languageElement));
		js.executeScript("arguments[0].scrollIntoView(true);", elementToBeViewed);
		wait.until(ExpectedConditions.elementToBeClickable(ShowMore)).click();
	}
	
	public void printingAndWritingToExcel() throws Exception {
		Set <String> set = new HashSet<>();
		for(WebElement ele:listOfLanguage) {
			set.add(ele.getText());
		}
		ExcelUtils.writingToExcel(set);
		for(String setEle:set) {
			System.out.println("Languages with their count: "+setEle);
		}
		
	}
}

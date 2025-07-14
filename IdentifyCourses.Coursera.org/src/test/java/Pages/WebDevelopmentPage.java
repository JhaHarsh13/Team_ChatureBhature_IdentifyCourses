package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="(//*[contains(text(),'English')])[1]")
	WebElement englishElement;
	
	@FindBy(xpath="//div[@data-testid='language:English-false']/*/span/*/input")
	WebElement englishElementCheckBox;
	
	@FindBy(xpath="(//span[contains(text(),'Beginner')])[1]")
	WebElement beginnerElement;
	
	@FindBy(xpath="//div[@data-testid='productDifficultyLevel:Beginner-false']/*/span/*/input")
	WebElement beginnerElementCheckBox;
	
	@FindBy(xpath="//h3[contains(@class, 'cds-CommonCard-title')]")
	List <WebElement> courseNames;
	
	@FindBy(xpath="//span[@class='css-6ecy9b']")
	List <WebElement> reviewEle;
	
	@FindBy(xpath="//div[@class='cds-CommonCard-metadata']/p")
	List<WebElement> timeElements;
	
	public void enterElementandClickToSearch(String entry1) {
		wait.until(ExpectedConditions.visibilityOf(inputField)).clear();
		wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(entry1);
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
		String timeArr[];
		for(int i=0; i<2; i++) {
			String time=timeElements.get(i).getText();
			String regex="\\d+\\s*-\\s*\\d+\\s*(Months|Weeks)";
			Pattern pattern=Pattern.compile(regex);
			Matcher matcher=pattern.matcher(time);
			System.out.print("Course Names: "+courseNames.get(i).getText()+", ");
			System.out.print("Reviews: "+reviewEle.get(i).getText()+", ");
			while(matcher.find()) {
				String resultTime=matcher.group()+"";
				System.err.print("Learning period: "+resultTime+" ");
			}
			System.err.println();
		}
	}
}

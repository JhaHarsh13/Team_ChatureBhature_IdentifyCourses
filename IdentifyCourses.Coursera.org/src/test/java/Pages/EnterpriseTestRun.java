package Pages;
import ConfigureReader.ConfigReader;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EnterpriseTestRun {
public static void main(String[] args) {
	WebDriver driver=null;
	
	try {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\2408354\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options); // Initialize the instance driver
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get(ConfigReader.getProperty("baseUrl"));
        
        EnterprisePage page=new EnterprisePage(driver);
        page.scrollAndClickForEnterprise();
        page.scrollToForm();
        page.setValuesIntoForm(
        		ConfigReader.getProperty("firstName"),
        		ConfigReader.getProperty("lastName"),
        		ConfigReader.getProperty("email"),
        		ConfigReader.getProperty("phoneNo"),
        		ConfigReader.getProperty("title"),
        		ConfigReader.getProperty("name")
        		
        		);
        
        page.submitForm();
        page.displayErrorMessage();
        
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(driver!=null) {
			driver.quit();
		}
	}
}
}

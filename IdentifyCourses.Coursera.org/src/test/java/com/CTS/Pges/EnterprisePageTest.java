

package com.CTS.Pges; // A new package for standalone classes, or you can choose an existing one

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.CTS.Pges.EnterprisePage; // Corrected package name based on your provided code
import ConfigureReader.ConfigReader; // Import your ConfigReader
import org.testng.annotations.Test;
public class EnterprisePageTest {

    public static void main(String[] args) {
        WebDriver driver = null; // Initialize driver to null
        try {
            
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            EnterprisePage enterprisePage = new EnterprisePage(driver);

            
            String baseUrl = ConfigReader.getProperty("baseUrl");
            String firstName = ConfigReader.getProperty("firstName");
            String lastName = ConfigReader.getProperty("lastName");
            String email = ConfigReader.getProperty("email");
            String phoneNo = ConfigReader.getProperty("phoneNo");
            String title = ConfigReader.getProperty("title");
            String name = ConfigReader.getProperty("name");

          //  System.out.println("Navigating to base URL: " + baseUrl);
            driver.get(baseUrl);

           // System.out.println("Scrolling and clicking 'For Enterprise' link...");
            enterprisePage.scrollAndClickForEnterprise();

           // System.out.println("Scrolling to the form section...");
            enterprisePage.scrollToForm();

          //  System.out.println("Filling the contact form with provided details...");
            enterprisePage.setValuesIntoForm(firstName, lastName, email, phoneNo, title, name);

           // System.out.println("Clicking the submit button...");
            enterprisePage.submitForm();

           // System.out.println("Taking screenshot of the error message (if any)...");
            enterprisePage.takeScreenShot();

            System.out.println("Displaying the error message...");
            enterprisePage.displayErrorMessage();

        } catch (Exception e) {
           
            e.printStackTrace(); 
        } finally {
           
            if (driver != null) {
                System.out.println("Closing the browser...");
                driver.quit();
            }
        }
    }
    
	
	
    
}
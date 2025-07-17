package com.CTS.PageUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageReloadingClass {
	public static void waitForElementWithRefresh(WebDriver driver, By locator, int maxAttempts) throws Exception {
		int attempts=0;
		boolean found=false;
		while(attempts<maxAttempts) {
			try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				found=true;
				return;
			}catch(Exception ex){
				attempts++;
				System.out.println("Page is not loaded yet, loading.....");
				driver.navigate().refresh();
			}
		}
		if(!found) {
			throw new Exception("PAge failed to load even after re-attempts");
		}
	}
}

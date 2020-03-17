package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
	public static By clickOnmyAccountLoc = By.xpath("//a[text()='My Account']");
	public static By demoSiteLoc = By.linkText("Demo Site");
	
	
	public static void clickOnMyAccount(WebDriver driver)
	{
		driver.findElement(clickOnmyAccountLoc).click();;
	}

	public static void clickOnDemosite(WebDriver driver) {
		
		driver.findElement(demoSiteLoc).click();
		
	}

}

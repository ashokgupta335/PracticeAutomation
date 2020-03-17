package com.cts.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebDriver 
{	//public static  WebDriver driver;

	public static WebDriver setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	public static void tearDown(WebDriver driver)
	{
		driver.quit();
	}
}

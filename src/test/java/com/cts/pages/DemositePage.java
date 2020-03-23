package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemositePage {
	private static By firstNameLoc = By.xpath("//input[@placeholder='First Name']");
	private static By lastNameLoc = By.xpath("//input[@placeholder='Last Name']");
	private static By addressLoc = By.tagName("textarea");
	private static By emailLoc = By.xpath("//input[@type='email']");
	private static By mobileNumLoc = By.xpath("//input[@type='tel']");
	private static By genderLoc = By.xpath("//input[@value='Male']");
	private static By hobbies_1Loc = By.xpath("//input[@value='Cricket']");
	private static By hobbies_2Loc = By.xpath("//input[@value='Movies']");
	private static By langLoc = By.id("msdd");
	private static By lang_1Loc = By.xpath("//a[text()='Arabic']");
	private static By lang_2Loc = By.xpath("//a[text()='English']");
	private static By skillsLoc = By.id("Skills");
	private static By countriesLoc = By.id("countries");
	private static By countries_1Loc = By.id("country");
	private static By yearLoc = By.id("yearbox");
	private static By monthLoc = By.xpath("//select[@placeholder='Month']");
	private static By dayLoc = By.id("daybox");
	private static By passLoc = By.id("firstpassword");
	private static By confrmPassLoc = By.id("secondpassword");
	private static By refreshLoc = By.xpath("//button[text()='Refresh']");
	private static By switchToLoc = By.linkText("SwitchTo");
	private static By alertsLoc = By.linkText("Alerts");
	private static By widgetsLoc = By.linkText("Widgets");
	private static By autoCompleteLoc = By.linkText("AutoComplete");
	private static By moreEleLoc = By.linkText("More");
	private static By modalsLoc = By.linkText("Modals");
	private static By emptyFirstnameLoc = By.xpath("//input[@placeholder='First Name']");
	private static By searchBoxLoc = By.id("searchbox");
	private static By indiaLoc = By.xpath("//a[text()='India']");
	private static By malaysiaLoc = By.xpath("//a[text()='Malaysia']");
	private static By boxCountry_1Loc = By.xpath("//div[text()='India']");
	private static By videoLoc = By.linkText("Video");
	private static By vimeoLoc = By.xpath("//a[text()='Vimeo']");
	private static By playVideoLoc = By.xpath("//div[@class='play-icon']");
	private static By alertClickLoc = By.xpath("//button[contains(text(),'display an  alert box')]");

	public static void formFilling(WebDriver driver, String firstName, String lastName, String address, String email,
			String num, String skill, String workCountry, String presentCountry, String birthYear, String birthMonth,
			String birthDay, String password, String confirmPass) {
		driver.findElement(firstNameLoc).sendKeys(firstName);

		driver.findElement(lastNameLoc).sendKeys(lastName);

		driver.findElement(addressLoc).sendKeys(address);

		driver.findElement(emailLoc).sendKeys(email);

		driver.findElement(mobileNumLoc).sendKeys(num);

		driver.findElement(genderLoc).click();

		driver.findElement(hobbies_1Loc).click();

		driver.findElement(hobbies_2Loc).click();

		driver.findElement(langLoc).click();

		driver.findElement(lang_1Loc).click();

		driver.findElement(lang_2Loc).click();

		Select skills = new Select(driver.findElement(skillsLoc));
		skills.selectByVisibleText(skill);

		Select country = new Select(driver.findElement(countriesLoc));
		country.selectByVisibleText(workCountry);

		Select country1 = new Select(driver.findElement(countries_1Loc));
		country1.selectByVisibleText(presentCountry);

		Select year = new Select(driver.findElement(yearLoc));
		year.selectByVisibleText(birthYear);

		Select month = new Select(driver.findElement(monthLoc));
		month.selectByVisibleText(birthMonth);

		Select day = new Select(driver.findElement(dayLoc));
		day.selectByVisibleText(birthDay);

		driver.findElement(passLoc).sendKeys(password);

		driver.findElement(confrmPassLoc).sendKeys(confirmPass);

		driver.findElement(refreshLoc).click();

	}

	public static String getTitleOfPage(WebDriver driver) {

		return driver.getTitle();

	}

	public static void clickOnAlerts(WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(switchToLoc)).pause(2000).build().perform();
		driver.findElement(alertsLoc).click();
		action.moveToElement(driver.findElement(alertClickLoc)).pause(2000).click().build().perform();
	}

	public static void clickOnAutoComplete(WebDriver driver, String country_1, String country_2) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(widgetsLoc)).pause(2000).build().perform();
		driver.findElement(autoCompleteLoc).click();
		driver.findElement(searchBoxLoc).sendKeys(country_1);
		driver.findElement(indiaLoc).click();
		driver.findElement(searchBoxLoc).sendKeys(country_2);
		driver.findElement(malaysiaLoc).click();
	}

	public static void clickOnModals(WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(moreEleLoc)).pause(2000).build().perform();
		driver.findElement(modalsLoc).click();
	}

	public static String afterRefresh(WebDriver driver) {

		return driver.findElement(emptyFirstnameLoc).getText();

	}

	public static String getFilledCountryName(WebDriver driver) {

		return driver.findElement(boxCountry_1Loc).getText();

	}

	public static void clickOnVimeo(WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(videoLoc)).pause(2000).moveToElement(driver.findElement(vimeoLoc)).pause(2000).click().build().perform();

		driver.switchTo().frame("foo");
		action.moveToElement(driver.findElement(playVideoLoc)).click().pause(5000).build().perform();

	}

}

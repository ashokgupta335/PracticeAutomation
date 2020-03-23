package com.cts.stepdefinitions;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cts.base.LaunchingWebBrowser;
import com.cts.pages.DemositePage;
import com.cts.pages.MyAccount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	WebDriver driver;

	@Given("User launch the browser with practiceautomationtestingPage")
	public void user_launch_the_browser_with_practiceautomationtestingPage() {

		driver = LaunchingWebBrowser.setUp();
		driver.get("http://practice.automationtesting.in/");
		MyAccount.clickOnDemosite(driver);
	}

	@When("I fill the form by using below data")
	public void i_fill_the_form_by_using_below_data(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<Map<String, String>> data = dataTable.asMaps();
		DemositePage.formFilling(driver, data.get(0).get("firstName"), data.get(0).get("lastName"),
				data.get(0).get("address"), data.get(0).get("email"), data.get(0).get("number"),
				data.get(0).get("skill"), data.get(0).get("workCountry"), data.get(0).get("presentCountry"),
				data.get(0).get("birthYear"), data.get(0).get("birthMonth"), data.get(0).get("birthDay"),
				data.get(0).get("password"), data.get(0).get("confirmPassword"));

	}

	@Then("Assert for the firstname text box")
	public void assert_for_the_firstname_text_box() {

		String actual = DemositePage.afterRefresh(driver);
		System.out.println(actual);
		Assert.assertTrue(actual.contentEquals(""));
		LaunchingWebBrowser.tearDown(driver);

	}

	@Then("I should get a page with {string} title")
	public void i_should_get_a_page_with_title(String expected) {

		String actual = DemositePage.getTitleOfPage(driver);
		Assert.assertTrue(actual.equals(expected));
		System.out.println("Passed");
		LaunchingWebBrowser.tearDown(driver);

	}

	@When("I hover to widgets and click on AutoComplete and filled the two country names as {string} and {string}")
	public void i_hover_to_widgets_and_click_on_AutoComplete_and_filled_the_two_country_names_as_and(String country1,
			String country2) {

		DemositePage.clickOnAutoComplete((driver), country1, country2);

	}

	@When("I hover to more and click on modals")
	public void i_hover_to_more_and_click_on_modals() {

		DemositePage.clickOnModals(driver);

	}

	@Then("the box should contains the given two country names")
	public void the_box_should_contains_the_given_two_country_names() {

		Assert.assertTrue((DemositePage.getFilledCountryName(driver)).contains("India"));
		LaunchingWebBrowser.tearDown(driver);

	}

	@When("I hover to video and click vimeo and click on video screen")
	public void i_hover_to_video_and_click_vimeo_and_click_on_video_screen() {

		DemositePage.clickOnVimeo(driver);

	}

	@Then("Video should play")
	public void video_should_play() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshots/video.png"));
		System.out.println("Passed");
		LaunchingWebBrowser.tearDown(driver);

	}

	@When("I hover to switchTo and click on alerts")
	public void i_hover_to_switchTo_and_click_on_alerts() {

		DemositePage.clickOnAlerts(driver);

	}

	@Then("I should get a alert")
	public void i_should_get_a_alert() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue((driver.switchTo().alert().getText()).contains("alert"));
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		LaunchingWebBrowser.tearDown(driver);

	}

}
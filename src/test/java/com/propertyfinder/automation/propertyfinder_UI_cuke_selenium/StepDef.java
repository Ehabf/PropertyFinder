package com.propertyfinder.automation.propertyfinder_UI_cuke_selenium;


import java.util.Properties;

import helper.WriteToTextFile;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import Pages.AgentPersonalPage;
import Pages.AgentSearchResultsPage;
import Pages.DriverManager;
import Pages.HomePage;
import Pages.SearchResultsPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	Properties props = new Properties();
	
	String browser = System.getProperty("browser");
	
	WebDriver driver = DriverManager.initializeDriver(browser);

	HomePage homePage = new HomePage(driver);
	SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
	AgentSearchResultsPage agentSearchResultsPage = new AgentSearchResultsPage(
			driver);
	AgentPersonalPage agentPersonalPage = new AgentPersonalPage(driver);

	@Given("^the user wants to search for a property on ([^\"]*)")
	public void the_user_wants_to_search_for_a_property_on_country(
			String country) throws Throwable {
		homePage.NavigateToPropertyFinder(country);

	}

	@When("^the user searches for a ([^\"]*) to ([^\"]*)$")
	public void the_user_searches_for_property_to_category_in_location(
			String property, String category) throws Throwable {

		homePage.selectPropertyType(property);
		homePage.selectCategory(category);

	}

	@When("^the ([^\"]*) has (\\d+) minimum and (\\d+) maximum bids$")
	public void the_property_has_minimum_and_maximum_bids(String property,
			int min, int max) throws Throwable {
		homePage.selectMinBed(min);
		homePage.selectMaxBed(max);
	}

	@When("^the ([^\"]*) in ([^\"]*) location$")
	public void the_Villa_in_The_Pearl_location(String property, String location)
			throws Throwable {
		homePage.searchLocation(location);
	}

	@When("^the user clicks find$")
	public void the_user_clicks_find() throws Throwable {
		searchResultsPage = homePage.clickFind();
	}

	@When("^the user clicks find agent$")
	public void the_user_clicks_find_agent() throws Throwable {
		agentSearchResultsPage.clickFind();
	}

	@Then("^the user can see the agent results based on provided search cretieria$")
	public void the_user_can_see_the_agent_results_based_on_provided_search_cretieria()
			throws Throwable {
	}

	@Then("^the user can see the results based on provided search cretieria$")
	public void the_user_can_see_the_results_based_on_provided_search_cretieria()
			throws Throwable {
	}
	
	@Then("^the user sorts the price from maximum price to lowest price$")
	public void the_user_sorts_the_price_from_maximum_price_to_lowest_price()
			throws Throwable {
		searchResultsPage.sortByPriceHigh();

	}

	@Then("^the user saves all the prices in a csv file with format$")
	public void the_user_saves_all_the_prices_in_a_csv_file_with_format()
			throws Throwable {
		String count = searchResultsPage.getSearchResultCount();
		count = count.substring(0, 1);
		searchResultsPage.savePrices(count);
	}

	@Given("^the user wants to find an agent on ([^\"]*)$")
	public void the_user_wants_to_find_an_agent_on_country(String country)
			throws Throwable {
		homePage.NavigateToPropertyFinder(country);
	}

	@When("^the user clicks on agent tab$")
	public void the_user_click_on_agent_tab() throws Throwable {
		agentSearchResultsPage = homePage.clickAgentTab();
	}

	@When("^the user wants an agent who can speak HINDI, ENGLISH and ARABIC langauages$")
	public void the_user_wants_an_agent_who_can_speak_languages()
			throws Throwable {
		agentSearchResultsPage.selectLanguages();
	}

	@Then("^the user notes down the total count of agents")
	public void the_user_notes_down_the_first_count_of_agents()
			throws Throwable {
		String CountA = agentSearchResultsPage.getAgentSearchResultsCount();
		CountA = CountA.replaceAll("\\D.*", "");
		CountA = CountA.replaceAll("\\D.*", "");
		props.put("SearchResults1", CountA);
		System.out.println("key: " + "SearchResults1" + " value: " + CountA);
	}

	@Then("^the user adds further filter agents from ([^\"]*)$")
	public void the_user_adds_further_filter_agents_from_country(String country)
			throws Throwable {
		agentSearchResultsPage.selectNationality(country);
	}

	@Then("^the user notes down the count of agents again")
	public void the_user_notes_down_the_second_total_count_of_agents_again()
			throws Throwable {
		Thread.sleep(2000);
		String CountB = agentSearchResultsPage.getAgentSearchResultsCount();
		CountB = CountB.replaceAll("\\D.*", "");
		props.put("SearchResults2", CountB);
		System.out.println("key: " + "SearchResults2" + " value: " + CountB);
	}

	@SuppressWarnings("deprecation")
	@Then("^assert that latest count is less than the previous count$")
	public void assert_that_latest_count_is_less_than_the_previous_count()
			throws Throwable {
		String result1 = props.getProperty("SearchResults1");
		String result2 = props.getProperty("SearchResults2");

		int count1 = Integer.parseInt(result1);
		int count2 = Integer.parseInt(result2);

		Assert.assertTrue("Search result 2 is greater than search result 1",
				count1 > count2);

	}

	@When("^the user selects first agent$")
	public void the_user_selects_first_agent() throws Throwable {
		agentPersonalPage = agentSearchResultsPage.selectAgent();
	}

	@Then("^the user can capture the agent info and write the info in text file$")
	public void the_user_can_capture_the_agent_info() throws Throwable {
		String textFileToSave = System.getProperty("user.dir")
				+ "/AgentInfo.txt";

		String info = agentPersonalPage.getAgentInfo();

		WriteToTextFile.main(info, textFileToSave);
	}

	@Then("^the user can capture screenshot of the page$")
	public void the_user_can_capture_screenshot_of_the_page() throws Throwable {
		agentPersonalPage.takeScreenshot();
	}

	@Then("^the user changes the language to Arabic$")
	public void the_user_changes_the_language_to_Arabic() throws Throwable {
		agentPersonalPage.changePageLanguage();
	}

	@After
	public void CloseBrowser() throws Throwable {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}

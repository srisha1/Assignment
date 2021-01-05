package com.kayak.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kayak.base.*;
import com.kayak.pages.KayakHomePage;
import com.kayak.pages.KayakSearchResultPage;
import com.kayak.utility.KayakReusableFunctions;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KayakStepDefinitions extends KayakBase {
	KayakReusableFunctions functions=new KayakReusableFunctions();
	KayakHomePage homepage;
	KayakSearchResultPage searchPage;
	
	@Given("^I launched in the kayak application for \"([^\"]*)\"$")
	public void i_launched_in_the_kayak_application_for(String testName) throws Throwable {
		
		logger = report.startTest("Usecase 1 "+testName);
		logger.log(LogStatus.INFO, "Starting Usecase 1...");
	    
	}

	@Then("^I verify the home page using homePageTitle$")
	public void i_verify_the_home_page_using_homePageTitle() throws Throwable {
	    
		homepage=new KayakHomePage(driver);
		String ActualTitle = homepage.titleOfHomePage();
		String expected = "Cheap Flights, Airline Tickets & Airfare Deals | KAYAK";		
		Assert.assertEquals(ActualTitle, expected);
	}
	
	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" cities$")
	public void i_enter_the_and_cities(String Origin, String Destination) throws Throwable {
	
		homepage.enterOriginCity(Origin);
		homepage.enterDestinationCity(Destination);
		
	}
	
	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" dates$")
	public void i_enter_the_and_dates(String DepartureDate, String ReturnDate) throws Throwable {
	  
		homepage.enterStartDate(DepartureDate);	
		homepage.enterReturnDate(ReturnDate);
	}
	
	@When("^I click on search icon$")
	public void i_click_on_search_icon() throws Throwable {
	   
		homepage.clickSearch();	  
	}	
	
	@Then("^I verify the search page using \"([^\"]*)\"$")
	public void i_verify_the_search_page_using(String titleSearch) throws Throwable {
	    
		searchPage = new KayakSearchResultPage(driver);		
		String actualTitle = searchPage.titleOfSearchPage();
		String expectedTitle = titleSearch;		
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		
	}

	@Then("^On search results page, I select the search result \"([^\"]*)\" , where N is the input data$")
	public void on_search_results_page_I_select_the_search_result_where_N_is_the_input_data(String N) throws Throwable {
	   
		searchPage.clickNthNumber(N);
	   
	}

	@Then("^I Assert the \"([^\"]*)\" and \"([^\"]*)\" Details are same as the one entered in the main screen$")
	public void i_Assert_the_and_Details_are_same_as_the_one_entered_in_the_main_screen(String Origin, String Destination) throws Throwable {
	    		
		String resultText = searchPage.resultFromSelected();
		System.out.println("result text " + resultText);
		Assert.assertTrue(resultText.contains(Origin));
		Assert.assertTrue(resultText.contains(Destination));
	}

	@Then("^Usecase \"([^\"]*)\" is completed$")
	public void usecase_is_completed(String testName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(LogStatus.PASS, "Usecase 1 "+testName +" Completed successfully");
	}
	
}

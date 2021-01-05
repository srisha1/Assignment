Feature: Kayak Application


Scenario Outline: UseCase1
Given I launched in the kayak application for "<testName>"
Then I verify the home page using homePageTitle
When I enter the "<Origin>" and "<Destination>" cities
And I enter the "<DepartureDate>" and "<ReturnDate>" dates
And I click on search icon
Then I verify the search page using "<titleSearch>" 
And On search results page, I select the search result "<N>" , where N is the input data
Then I Assert the "<OriginCode>" and "<DestinationCode>" Details are same as the one entered in the main screen
And Usecase "<testName>" is completed 


Examples:
|testName|Origin|Destination|DepartureDate|ReturnDate|titleSearch|N|OriginCode|DestinationCode|
|test1|Bengaluru|Chennai|11/15/2020|12/12/2020|BLR to MAA|3|BLR|MAA|
#|test2|Bengaluru|Dallas|11/01/2020|11/15/2020|BLR to DFW|2|BLR|DFW|

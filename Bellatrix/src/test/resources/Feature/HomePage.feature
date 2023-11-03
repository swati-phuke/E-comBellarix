#allure report = http://192.168.43.217:58628/index.html
Feature:  Secenario mention in this file we will test Searchcomponent for different Type


@Regression
Scenario: VeryFy search results for Falcon
 Given Application launched is complatly
 When User searches Falcon in searchComponent
 Then All result must contain Falcon word in product title
 
 @Sanity
 Scenario: Open the Application
When Url is launch Open the Application

@Smoke
Scenario Outline: To verify search results for product
Given I have <num_row>
Then Provide the product Name using excel seat
 And Check All Product Title must be contain ProductName

Examples: 
|num_row| 
|1|
|2|
|3|
|4|


 @Regression
Scenario: handle dropDown List
Given click on dropDown List
When select Option our requirement

@Regression
Scenario: To verify Get information about product
Given Search the product
Then click on readmore buttton And get information about product

@Regression
Scenario: To verify we have insert intial 3 word We cas disply releated Product Name
Given Application must be open And insert first letter in searchBox
Then  Display realeted ProductName

Scenario Outline: To verify DDT on dropDown
Given I Have <Num>
When  Click on DropDown
And We select option our requirement Then display related page 
Examples: 
|Num|
|1|
|2|
|3|
|4|
|5|


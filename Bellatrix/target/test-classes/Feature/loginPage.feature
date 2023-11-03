Feature: In this scenario we will checking login page
Scenario: To verify if click on  myaccount btn successfully open login page
Given Click on  myaccount btn

Scenario: To verify if required email field is empty and click on login btn  will get error msg.
Given  Click on  myaccount btn
When fill required field
Then check error 

@Smoke
Scenario: To verify if required password field is empty and click on login btn  will get error msg.
Given  Click on  myaccount btn
When fill required fields
Then Check error msg


Scenario: To verify if required  field is fullfill and click on login btn  will login successfully.
Given  Click on  myaccount btn
When fill all required fields
Then check successfully login
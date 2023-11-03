Feature: In this file we will check blogs page
Scenario: Open blog page
Given Click on blog page

Scenario: Open manufacturer link of proton-k rocket
Given click on blog page
Then click on manufacturer link of proton-k

Scenario: Open manufacturer link of Falcon rocket
Given click on blogs page
Then click on manufacturer link of Falcon


Scenario: Post Comment on Proton-k Rocket
Given Open blog pages
When Click on Proton-k rocket
Then fill the required fiels for comment post
@Smoke
Scenario: To verify if required field is empty and click on postcomment btn  will get error msg.
Given Open blog pages
When Click on Proton-k rocket
Then fill the required fiels for comment post
Then get error msg

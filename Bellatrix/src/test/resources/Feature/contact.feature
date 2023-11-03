Feature: Summition of contact form
Scenario: To verify click on contact btn open contact form.
Given Click on contact button

Scenario: To verify all required field is not fill we can not able sumit contact form 
Given open the contact form
When fill info in field and leave one blank field
Then click On sumit and check massage that fill required field

Scenario: To verify all required field is fulfill and summit the form
Given Open the contact form
When fill info all field
Then Click On summit button and check massage 


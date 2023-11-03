Feature: In this feature file we will test add-cart button for different Types
Scenario: To verify if click on Add to cart Btn then display View cart Btn
Given Search product in search box
When Click on Add to cart btn
Then Display View cart btn
@Regression
Scenario: To verify on click add to cart btn related product should be display in cart
Given Search product1 in search box
When Click on add to cart btn
Then click on View cart btn And display product in cart


Scenario: To verify on click add to cart btn related product price should be display in Cart
Given Search Product in search box
When Click on add to cart button
Then click on View cart btn And display product price in cart

Scenario: To verify on click add to cart btn related product quantity should be display in Cart
Given Search Product1 in search box
When Click on add to cart button1
Then click on View cart btn And display product quatity in cart


Scenario: To verify on click add to cart btn related product subtotal should be display in Cart
Given Search ProductName insert in search box
When Click on add to cart button2
Then click on View cart button And display product subtotal in cart
@smoke
Scenario: Display final value of all products in CartTotal.
Given get value of subtotal and vat
When  Add subtotal and vat
Then  compare subtotal and vat with Total




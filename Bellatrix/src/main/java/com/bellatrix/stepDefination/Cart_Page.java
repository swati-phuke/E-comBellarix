package com.bellatrix.stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bellatrix.pages.Cart_page;
import com.bellatrix.pages.HomePage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cart_Page {
	private static final Logger LOG = Logger.getLogger(Cart_Page.class);
	Cart_page page = PageFactory.initElements(TestBase.driver, Cart_page.class);
	HomePage homepage = PageFactory.initElements(TestBase.driver, HomePage.class);
	WaitFor wait = new WaitFor();
	@Given("Search product in search box")
	public void search_product_in_search_box() {
	  homepage.searchBox("Falcon 9");
	  
	}

	@When("Click on Add to cart btn")
	public void click_on_add_to_cart_btn() {
		
		wait.implicitWait(4);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}

	@Then("Display View cart btn")
	public void display_view_cart_btn() { 
	String title =	page.getViewBTN();
	LOG.info("Button Name"+title);
	System.out.println("Button Name :"+ title);
		
	}  
	@Given("Search product1 in search box")
	public void search_product1_in_search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart btn")
	public void click_on_add_to_cart_btn1() {
		wait.implicitWait(3);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}
	@Then("click on View cart btn And display product in cart")
	public void click_on_view_cart_btn_and_display_product_in_cart() {
	 page.clickOnViewBtn();
	String text = page.productText();
	String productName = page.product();
	LOG.info(text+"= "+productName );
	System.out.println(text +"="+ productName);
	 
	}
	@Given("Search Product in search box")
	public void search_Product1_In_Search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart button")
	public void click_On_dd_to_Cart_Btn1() {
		wait.implicitWait(3);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}
	@Then("click on View cart btn And display product price in cart")
	public void click_on_view_cart_btn1_and_display_price() {
	 page.clickOnViewBtn();
	String text = page.priceText();
	String productName = page.price();
	LOG.info(text+"= "+productName );
	System.out.println(text +"="+ productName);
	 
	}
	@Given("Search Product1 in search box")
	public void search_Product1_in_Search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart button1")
	public void click_On_Add_to_Cart_Btn1() {
		wait.implicitWait(3);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}
	@Then("click on View cart btn And display product quatity in cart")
	public void click_on_view_cart_btn_and_display_price() {
	 page.clickOnViewBtn();
	String text = page.quantityText();
	String productName = page.quantity();
	LOG.info(text+"= "+productName );
	System.out.println(text +"="+ productName);
	 
	}
	//-----------------------------------------------------------------
	
	@Given("Search ProductName insert in search box")
	public void search_Product2_in_Search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart button2")
	public void click_On_Add_to_Cart_Btn2() {
		wait.implicitWait(3);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}
	@Then("click on View cart button and display product subtotal in cart")
	public void click_on_view_cart_btn_and_display_price1() {
	 page.clickOnViewBtn();
	String text = page.subTotalText();
	String productName = page.subTotal();
	LOG.info(text+"= "+productName );
	System.out.println(text +"="+ productName);
	 
	}
	String subprice;
	String vatprice;
	String price;
	String total;
	@Given("get value of subtotal and vat")
	public void get_value_of_subtotal_And_vat() {
		
	homepage.searchBox("Falcon 9");
	page.scrollby();
		page.clickOnAddTOCartBtn();
		wait.implicitWait(3);
		page.clickOnViewBtn();
		
		page.scrollby();
		 subprice = page.cartsubTotalp();
		vatprice = page.vatprice();
		
		
	}
	@When("Add subtotal and vat")
public void add_subtotal_and_vat() {
	 price = subprice+vatprice;
	 total = page.totalprice();
	}
	@Then("compare subtotal and vat with Total")
	public void compare_subtotal_and_vat_with_total() {
		 total = page.totalprice();
		Assert.assertEquals(total, price);
		
	}
	

}

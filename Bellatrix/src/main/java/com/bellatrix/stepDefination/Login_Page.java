package com.bellatrix.stepDefination;

import javax.swing.text.html.CSS;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.bellatrix.pages.LoginPage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Page {
	private static final Logger LOG = Logger.getLogger(Login_Page.class);
	LoginPage page = PageFactory.initElements(TestBase.driver, LoginPage.class);
	WaitFor wait = new WaitFor();
	@Given("Click on  myaccount btn")
	public void click_on_my_account_btn() {
		page.clickOnmyaccount();
		String breadcrum = page.getBreadcrum();
		LOG.info("my account page successfully open" + breadcrum);
	}

	@When("fill required field")
	public void fill_required_field() {
     page.password("12345678");
     wait.implicitWait(3);
     page.clickOncheckbox();
     page.clickOnloginbtn();
	}
	@Then("check error msg")
	public void get_massage() {
		wait.implicitWait(3);
		String msg = page.emailErrmsg();
		LOG.error( "error msg" + msg);
	}
	@When("fill required fields")
	public void fill_field() {
		 page.username("phukeswati104@gmail.com");
	     wait.implicitWait(3);
	     page.clickOncheckbox();
	     page.clickOnloginbtn();
	
	}
	
	@Then("Check error msg")
	public void  show_msg() {
		String msg = page.passwordErr();
		LOG.error( "error msg" + msg);
		System.out.println(msg);
	}
	@When("fill all required fields")
	public void fill_all_field() {
		 page.username("phukeswati104@gmail.com");
		 wait.implicitWait(3);
		 page.password("S1w@a#t8");
	     wait.implicitWait(3);
	     page.clickOncheckbox();
	    	
	}
	@Then("check successfully login")
	public void login_successfully() {
		page.clickOnloginbtn();
	}
	
	
}

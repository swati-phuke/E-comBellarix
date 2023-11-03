package com.bellatrix.stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.bellatrix.pages.Cart_page;
import com.bellatrix.pages.ContactForm;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactPageDef {
	private static final Logger LOG = Logger.getLogger(ContactPageDef.class);
	ContactForm page = PageFactory.initElements(TestBase.driver, ContactForm.class);
	WaitFor scroll = new WaitFor();
	@Given("Click on contact button")
	public void openContactForm() {
		page.contactForm();
		LOG.info("contact form successfully open");
	}
	

@Given("open the contact form")
public void open_the_contact_form() {
  page.contactForm();  
}

@When("fill info in field and leave one blank field")
public void fill_info_in_field_and_leave_one_blank_field() throws InterruptedException {
	page.firstNameMethod("swati");
	page.lastName("Phuke");
	page.email("phukeswati!02@gmail.com");
	scroll.scrollby();
	page.bronzeOnclick();
	Thread.sleep(3000);
	page.session1Onclick();
	scroll.scrollby();
	page.yesOnclick();
	
	Thread.sleep(2000);
	
	page.sumitOnclick();
    
}

@Then("click On sumit and check massage that fill required field")
public void click_on_sumit_and_check_massage_that_fill_required_field() throws InterruptedException {
	Thread.sleep(2000);
   String msg = page.massage();
   System.out.println(msg);
   LOG.error(msg+"------------------------------------------------------------");
}
@Given("Open the contact form")
public void open_the_contact_formpage() {
  page.contactForm();  
}

@When("fill info all field")
public void fill_info_in_field_() throws InterruptedException {
	page.firstNameMethod("swati");
	page.lastName("Phuke");
	page.email("phukeswati!02@gmail.com");
	scroll.scrollby();
	page.bronzeOnclick();
	Thread.sleep(2000);
	page.session1Onclick();
	Thread.sleep(2000);
	page.yesOnclick();
	Thread.sleep(2000);
	scroll.scrollby();
	Thread.sleep(5000);
	page.captchaOnclick();
	Thread.sleep(2000);
	
	page.sumitOnclick();
    
}

@Then("Click On summit button and check massage")
public void click_on_sumit_button() throws InterruptedException {
	Thread.sleep(2000);
   String msg = page.contactmsg();
   System.out.println(msg);
   LOG.info(msg+"--------------------------------------------------------------------------");
}







}

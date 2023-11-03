package com.bellatrix.stepDefination;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.devtools.v113.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.bellatrix.keyword.Keyword;
import com.bellatrix.pages.HomePage;
import com.bellatrix.utilities.FileUtil;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTestCase {
	private static final Logger LOG = Logger.getLogger(HomePageTestCase.class);

	Keyword keyword = new Keyword();
	HomePage page = PageFactory.initElements(TestBase.driver, HomePage.class);

	@When("Url is launch Open the Application")
	public void url_is_launch_open_the_application() {
		LOG.info("Application is launch successfully-----------------------------------------------");

	}

	String ProductName;

	@Given("I have {int}")
	public void i_have(int row) throws IOException {
		FileUtil excel = new FileUtil();
		String[] data = excel.getRowFromExcel(
				"C:/Users/DELL/eclipse-workspace/Test/Matrimony/src/test/resources/BellatrixProductName.xlsx",
				"ProductName", row);
		this.ProductName = data[1];
	}

	@Then("Provide the product Name using excel seat")
	public void enter_Product_Name() {
		page.searchBox(ProductName);
	}

	@And("Check All Product Title must be contain ProductName")
	public void get_ProductTitle() {
		List<String> title = page.getProductList();
		SoftAssert softly = new SoftAssert();
		for (String ProductTitle : title) {
			softly.assertTrue(ProductTitle.contains(ProductName));
			LOG.info("Enter the product Name" + ProductTitle + "to search");

		}
		softly.assertAll();
		LOG.info("DDT handle with product Name using search box----------------------------------");
	}

	@Given("Application launched is complatly")
	public void application_launched_is_complatly() {
		// keyword.launchURL("https://demos.bellatrix.solutions");

	}

	@When("User searches Falcon in searchComponent")

	public void user_searches_falcon_in_search_component() {
		page.searchBox("Flacon");
	}

	@Then("All result must contain Falcon word in product title")
	public void all_result_must_contain_falcon_word_in_product_title() {
		List<String> title = page.getProductList();
		SoftAssert softly = new SoftAssert();
		for (String productName : title) {
			LOG.info("Enter the product Name" + productName + "to search");
			System.out.println(productName);

			softly.assertTrue(productName.contains("Falcon"));

		}
		softly.assertAll();
		LOG.info("Showing list of product title while searching in Searchbox-------------------------- ");
	}

	@Given("see dropDown List")
	public void see_drop_down_list() throws InterruptedException {
		page.clickOnDropDownList();
		LOG.info("Disply dropDown list Option------------------------------------------------------");
	}

	@Given("click on dropDown List")
	public void click_on_drop_down_list() throws InterruptedException {
		page.clickOnDropDownList();
	}

	@When("select Option our requirement")
	public void select_option_our_requirement() {
		page.handleDropDownList("popularity");
		LOG.info("Successfully open required dropdown Option-------------------------------------------");
	}

	@Given("Search the product")
	public void search_the_product() {
		page.searchBox("Proton-M");

	}

	@Then("click on readmore buttton And get information about product")
	public void click_on_readmore_buttton_and_get_information_about_product() throws Exception {
		page.clickOnReadMoreBtn();
		page.wait();
		String description = page.getInfoaboutProduct();
		System.out.println(description);
		LOG.info("Display description about product");

	}

	@Given("Application must be open And insert first letter in searchBox")
	public void insertCaracter() {
		page.searchBox("Fal");
	}

	@Then("Display realeted ProductName")
	public void displayRealetedSearch() {
		LOG.error("Result not display while insert incomplete product name----------------------------------------------");
		
	}

	String dropDown;

	@Given("I Have {int}")
	public void i_Have(int row) throws IOException {

		FileUtil excel = new FileUtil();
		String[] data = excel.getRowFromExcel(
				"C:/Users/DELL/eclipse-workspace/Test/Matrimony/src/test/resources/Bellatrix dropdown.xlsx", "dropDown",
				row);
		this.dropDown = data[1];
	}

	@When("Click on DropDown")
	public void click_on_drop_down() throws InterruptedException {
		page.clickOnDropDownList();
	}
	@When("We select option our requirement Then display related page")
	public void we_select_option_our_requirement_then_display_related_page() {
		WaitFor wait = new WaitFor();
		page.handleDropDownList(dropDown);
		wait.implicitWait(4);
		LOG.info("DDT provide value of dropdown list disply all required result----------");

	}

}

package com.rest_api_stepdeffination;

import org.apache.log4j.Logger;

import com.bellatrix.pages.BlogsPage;
import com.rest_api_page_package.RestApiMethod;

import groovyjarjarasm.asm.commons.Method;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Hit_RestApi_Method {
	private static final Logger LOG = Logger.getLogger(Hit_RestApi_Method.class);
	RestApiMethod method = new RestApiMethod();

	@Given("Using get method hit api")
	public void getMethod() {
		method.getMethod("https://reqres.in/api/users?page=2");
		LOG.info("get staus code 200Ok");
	}

	@Given("Using get method hit the data and get only body")
	public void only_get_body() {
		method.getMethodOnlyBody("https://reqres.in/api/users?page=2");
	}

	@Given("Using post method create the data")
	public void post_method() {
		method.postMethod("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}",
				"https://reqres.in/api/users");
	}

	@Given("Using  Authorization post method create data")
	public void authoriz_post_method() {
		method.postAuthorization("Bearer 9d2ee4da1e969724d02cc6b948d0f13002ea51d5d764fb4ae9375236f888b3ef",
				"{\r\n" + "    \"id\": 5191978,\r\n" + "    \"name\": \"Lakshmi Arora DDS\",\r\n"
						+ "    \"email\": \"arora1_lakshmi1_ddst@wiegand.co\",\r\n" + "    \"gender\": \"female\",\r\n"
						+ "    \"status\": \"inactive\"\r\n" + "}",
				"https://gorest.co.in/public/v2/users");
	}

	@Given("Update the given data")
	public void update_data() {
		method.putMethod("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}",
				"https://reqres.in/api/users/2");
	}

	@Given("Update the given data using authorization")
	public void update_data_using_autho() {
		method.putAuthorization("Bearer 9d2ee4da1e969724d02cc6b948d0f13002ea51d5d764fb4ae9375236f888b3ef",
				"{\r\n" + "    \"id\": 5191978,\r\n" + "    \"name\": \"Lakshmi Arora DDS\",\r\n"
						+ "    \"email\": \"arnra1_lakshmi8_ddst@wiegand34.co\",\r\n"
						+ "    \"gender\": \"female\",\r\n" + "    \"status\": \"inactive\"\r\n" + "}",
				"https://gorest.co.in/public/v2/users/628120");
	}

	@Given("Check partial update using patch method")
	public void check_partial_update() {
		method.patchMethod("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}",
				"https://reqres.in/api/users/2");

	}

	@Given("Delet the data using delete method")
	public void delete_the_data() {
		method.deletAuthorizationMethod("Bearer 9d2ee4da1e969724d02cc6b948d0f13002ea51d5d764fb4ae9375236f888b3ef",
				"{\r\n" + "    \"id\": 5191978,\r\n" + "    \"name\": \"Lakshmi Arora DDS\",\r\n"
						+ "    \"email\": \"arora1_lakshmi1_ddst@wiegand.co\",\r\n" + "    \"gender\": \"female\",\r\n"
						+ "    \"status\": \"inactive\"\r\n" + "}",
				"https://gorest.co.in/public/v2/users/628120");
	}

	@Given("read the data using json path")
	public void read_json_path() {
		method.readJsonPath("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}", "name");
	}

	@Given("read the list of data using json path")
	public void read_list_of_data() {
		method.readJsonPath("{\r\n" + "    \"data\": {\r\n" + "        \"id\": 2,\r\n"
				+ "        \"email\": \"janet.weaver@reqres.in\",\r\n" + "        \"first_name\": \"Janet\",\r\n"
				+ "        \"last_name\": \"Weaver\",\r\n"
				+ "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\r\n" + "    },\r\n"
				+ "    \"support\": {\r\n" + "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n" + "}", "data.first_name");
	}

	@Given("Get email id")
	public void get_email_id() {
		method.readJsonPath("{\r\n" + "    \"data\": {\r\n" + "        \"id\": 2,\r\n"
				+ "        \"email\": \"janet.weaver@reqres.in\",\r\n" + "        \"first_name\": \"Janet\",\r\n"
				+ "        \"last_name\": \"Weaver\",\r\n"
				+ "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\r\n" + "    },\r\n"
				+ "    \"support\": {\r\n" + "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n" + "}", "data.email");
	}

	@Given("Get email id in List of data")
	public void get_email_id_in_multiple_data() {
		method.readJsonPath("{\r\n" + "    \"page\": 2,\r\n" + "    \"per_page\": 6,\r\n" + "    \"total\": 12,\r\n"
				+ "    \"total_pages\": 2,\r\n" + "    \"data\": [\r\n" + "        {\r\n" + "            \"id\": 7,\r\n"
				+ "            \"email\": \"michael.lawson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Michael\",\r\n" + "            \"last_name\": \"Lawson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 8,\r\n"
				+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Lindsay\",\r\n" + "            \"last_name\": \"Ferguson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 9,\r\n"
				+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
				+ "            \"first_name\": \"Tobias\",\r\n" + "            \"last_name\": \"Funke\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 10,\r\n"
				+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
				+ "            \"first_name\": \"Byron\",\r\n" + "            \"last_name\": \"Fields\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 11,\r\n"
				+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
				+ "            \"first_name\": \"George\",\r\n" + "            \"last_name\": \"Edwards\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 12,\r\n"
				+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
				+ "            \"first_name\": \"Rachel\",\r\n" + "            \"last_name\": \"Howell\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n" + "        }\r\n"
				+ "    ],\r\n" + "    \"support\": {\r\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n" + "}\r\n" + "", "data[1].email");
		LOG.info("email" + "data[1].email");
	}

	@Given("Check the data is correct or incorrect")
	public void verify_the_data() {
		method.verificationMethodUsingJsonPath("{\r\n" + "    \"page\": 2,\r\n" + "    \"per_page\": 6,\r\n"
				+ "    \"total\": 12,\r\n" + "    \"total_pages\": 2,\r\n" + "    \"data\": [\r\n" + "        {\r\n"
				+ "            \"id\": 7,\r\n" + "            \"email\": \"michael.lawson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Michael\",\r\n" + "            \"last_name\": \"Lawson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 8,\r\n"
				+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Lindsay\",\r\n" + "            \"last_name\": \"Ferguson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 9,\r\n"
				+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
				+ "            \"first_name\": \"Tobias\",\r\n" + "            \"last_name\": \"Funke\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 10,\r\n"
				+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
				+ "            \"first_name\": \"Byron\",\r\n" + "            \"last_name\": \"Fields\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 11,\r\n"
				+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
				+ "            \"first_name\": \"George\",\r\n" + "            \"last_name\": \"Edwards\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 12,\r\n"
				+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
				+ "            \"first_name\": \"Rachel\",\r\n" + "            \"last_name\": \"Howell\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n" + "        }\r\n"
				+ "    ],\r\n" + "    \"support\": {\r\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n" + "}\r\n" + "", "data[0].email", "michael.lawson@reqres.in");
	}

	@Given("check the data is correct or not")
	public void check_the_data() {
		method.verificationMethodUsingJsonPath("{\r\n" + "    \"page\": 2,\r\n" + "    \"per_page\": 6,\r\n"
				+ "    \"total\": 12,\r\n" + "    \"total_pages\": 2,\r\n" + "    \"data\": [\r\n" + "        {\r\n"
				+ "            \"id\": 7,\r\n" + "            \"email\": \"michael.lawson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Michael\",\r\n" + "            \"last_name\": \"Lawson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 8,\r\n"
				+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Lindsay\",\r\n" + "            \"last_name\": \"Ferguson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 9,\r\n"
				+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
				+ "            \"first_name\": \"Tobias\",\r\n" + "            \"last_name\": \"Funke\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 10,\r\n"
				+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
				+ "            \"first_name\": \"Byron\",\r\n" + "            \"last_name\": \"Fields\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 11,\r\n"
				+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
				+ "            \"first_name\": \"George\",\r\n" + "            \"last_name\": \"Edwards\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 12,\r\n"
				+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
				+ "            \"first_name\": \"Rachel\",\r\n" + "            \"last_name\": \"Howell\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n" + "        }\r\n"
				+ "    ],\r\n" + "    \"support\": {\r\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n" + "}\r\n" + "", "data[1].email", "michael.lawson@reqres.in");
	}

	@Given("validate the data is correct or not")
	public void validate_the_data() {
		method.validationMethod("https://reqres.in/api/users/2", "data.first_name", "Janet");
	}

	@Given("Replace the Pathparameter")
	public void replace_path_parameter() {
		method.pathParameter("id", "2");

	}

	@Given("Set the querry parameter")
	public void set_querry_para() {
		method.querryParameter("page",2, "https://reqres.in/api/users/");
	}

	@Given("Get a resposne")
	public void get_response() {
		method.buildMethod("cf2bc2b87d36a6ce46ff3946cb363d3f80e3b5d5333870e8177d6792a60d9c28", "https://gorest.co.in/",
				"/public/v2/users/628186");
	}

	@Given("extract the name given response")
	public void extract_data() {
		method.extractMethod("cf2bc2b87d36a6ce46ff3946cb363d3f80e3b5d5333870e8177d6792a60d9c28",
				"https://gorest.co.in/", "/public/v2/users/628186","id");
	}

}

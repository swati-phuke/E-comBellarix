package com.rest_api_page_package;

import static io.restassured.RestAssured.given;


import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestApiMethod {
	private static final Logger LOG = Logger.getLogger(RestApiMethod.class);
	/**
	 * status code of get method 200 OK
	 * 
	 * @param url
	 */
	public void getMethod(String url) {
		given().when().get(url).then().log().all();

	}

	/**
	 * This method get only body
	 * 
	 * @param url
	 */
	public void getMethodOnlyBody(String url) {
		given().when().get(url).then().log().body();

	}

	/**
	 * status code of postMethod is 201 OK
	 * 
	 * @param body
	 * @param url
	 */
	public void postMethod(String body, String url) {
		given().contentType(ContentType.JSON).body(body)

				.when().post(url).then().log().all();
	}

	/**
	 * Put status code 200 OK Complate record updation by using put method
	 * 
	 * @param body
	 * @param url
	 */
	public void putMethod(String body, String url) {

		given().contentType(ContentType.JSON).body(body).when().put(url).then().log().all();
	}

	/**
	 * Only partial updation using patchmethod
	 */
	public void patchMethod(String body, String url) {

		given().contentType(ContentType.JSON).body(body).when().patch(url).then().log().all();

	}

	/**
	 * This method is delete all data Status code is 200 OK
	 * 
	 * @param url
	 * @param body
	 */
	public void deletMethod(String url, String body) {
		given().contentType(ContentType.JSON).body(body).when().delete(url).then().log().all();

	}

	/**
	 * This method is using Authorization
	 */
	public void postAuthorization(String bearerToken, String body, String url) {
		given().header("Authorization", bearerToken).contentType(ContentType.JSON).body(body).post(url).then().log()
				.all();

	}

	public void putAuthorization(String bearerToken, String body, String url) {
		given().header("Authorization", bearerToken).contentType(ContentType.JSON).body(body).put(url).then().log()
				.all();
	}

	public void deletAuthorizationMethod(String bearerToken, String body, String url) {
		given().header("Authorization", bearerToken).contentType(ContentType.JSON).body(body).delete(url).then().log()
				.all();
	}

	public void patchAuthorizationMethod(String bearerToken, String body, String url) {
		given().header("Authorization", bearerToken).contentType(ContentType.JSON).body(body).delete(url).then().log()
				.all();

	}

	/**
	 * In This method we can verify data using json path
	 * 
	 * @param bodys
	 * @param paths
	 * @param matchingdeta
	 */

	public void verificationMethodUsingJsonPath(String bodys, String paths, String matchingdeta) {

		String body = bodys;
		JsonPath path = new JsonPath(body);
		String email = path.getString(paths);
		// System.out.println(email);
		// if i can get specific data when i am apply if condition
		if (email.equals(matchingdeta)) {
			System.out.println(email);
		} else {
			System.out.println("not found data");
		}
		/**
		 * In this method we are verify data without mention body path= the path of data
		 * where the data is stored required data= our required data
		 * 
		 * @param url
		 * @param path @ param requireddata
		 */
	}

	public void validationMethod(String url, String path, String requireddata) {
		given().when().get(url).then().assertThat().body(path, Matchers.equalTo(requireddata))

				.log().all();

	}

	/**
	 * In json data store key value pair which value we have get this key is mention
	 * here eg.Id= "2" . Id is key and 2 is value
	 * 
	 * @param bodydata
	 * @param key
	 */

	public void readJsonPath(String bodydata, String key) {
		String body = bodydata;
		JsonPath path = new JsonPath(body);

		System.out.println(path.getString(key));
	}

	public void requestSpecificationMethod(String bearer, String uri, String basePath) {
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON).header("Authorization", bearer).baseUri(uri).basePath(basePath);
		given(request).get().then().log().all();

	}

	public void responseBuilder() {
		ResponseSpecBuilder speceBuilder = new ResponseSpecBuilder();
		speceBuilder.expectContentType(ContentType.JSON);
		speceBuilder.expectStatusCode(201);
		ResponseSpecification responce = speceBuilder.build();
	}

	/**
	 * in this method key is same as parameter
	 * 
	 * @param parameter
	 * @param value
	 * @param url
	 */

	public void querryParameter(String parameter, int value, String url) {
		given().pathParam(parameter, value) // in this cods key is same
				.when().get(url).then().log().all();

	}

	public void pathParameter(String key, String value) {
		given().pathParam("id", 2) // in this cods key is same
				.when().get("https://reqres.in/api/users/{id}").then().log().all();
	}

	/**
	 * In this method i get response i am extract value using extract method
	 * 
	 * @param bearer
	 * @param baseUri
	 * @param basePathUri
	 * @param requiredValueKey
	 */

	public void extractMethod(String bearer, String baseUri, String basePathUri, String requiredValueKey) {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		builder.addHeader("Authorization", bearer);
		builder.setBaseUri(baseUri);
		builder.setBasePath(basePathUri);
		RequestSpecification reques = builder.build();

		
		 String     res = given(reques).get().then().extract().asString();
	      JsonPath json = new JsonPath(res);
	      System.out.println(json.getInt(requiredValueKey));
	}

	public void buildMethod(String bearer, String baseUri, String basePathUri) {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		builder.addHeader("Authorization", bearer);
		builder.setBaseUri(baseUri);
		builder.setBasePath(basePathUri);
		RequestSpecification reques = builder.build();
		LOG.info("get only response" + reques);
	}
}

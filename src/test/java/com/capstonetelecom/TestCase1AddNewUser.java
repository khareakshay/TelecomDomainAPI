package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase1AddNewUser {

	@Test(priority = 1)
	public String postNewUser(UserPojo pdata) {
		
		System.out.println("==================TestCase-1 Add New User====================");


		Response res = RestAssured.given().contentType("application/json").body(pdata).when()
				.post("https://thinking-tester-contact-list.herokuapp.com/users");

		String token = res.getBody().jsonPath().getString("token");
		System.out.println("token - " + token);

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 201, "Status code not matched");
		System.out.println("Status Code Matched");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("Created"), "Status Message not matched");
		System.out.println("Status Message Matched");
		return token;
	}
}
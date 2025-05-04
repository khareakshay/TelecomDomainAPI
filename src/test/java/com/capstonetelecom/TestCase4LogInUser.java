package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase4LogInUser {
	@Test
	public String postLoginUser(UserPojo pdata) {

		System.out.println("==================TestCase-4 Login User====================");


		Response res = RestAssured.given().contentType("application/json")
				.body(pdata).when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
		System.out.println("Status code is 200");

		String actualstatusMessage = res.getStatusLine();
		Assert.assertTrue(actualstatusMessage.contains("OK"));
		System.out.println("Status Message is OK");

		String token = res.getBody().jsonPath().getString("token");
		System.out.println("Token- " + token);
		return token;
	}
}

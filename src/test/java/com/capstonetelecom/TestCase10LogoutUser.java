package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase10LogoutUser {
	@Test
	public void postLogoutUser(String token) {

		System.out.println("==================TestCase-10 Post Logout User====================");

		Response res = RestAssured.given().header("Authorization", "Bearer " + token).when()
				.post("https://thinking-tester-contact-list.herokuapp.com/users/logout");

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Status code not matched");
		System.out.println("Status Code is 200");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("OK"), "Status message is not matched");
		System.out.println("Status message is - OK");

	}
}

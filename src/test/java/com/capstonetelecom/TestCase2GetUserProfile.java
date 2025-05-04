package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase2GetUserProfile {
	@Test
	public void getUserProfile(UserPojo pdata) {

		System.out.println("==================TestCase-2 Get User Profile====================");

		Response res = RestAssured.given().header("Authorization", "Bearer " + pdata.getToken()).when()
				.get("https://thinking-tester-contact-list.herokuapp.com/users/me");

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Status code not matched");
		System.out.println("Status Code Matched");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("OK"), "Status Message not matched");
		System.out.println("Status Message Matched");

	}
}

package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase3UpdateUser {
	@Test
	public void patchUpdateUser(UserPojo pdata) {

		System.out.println("==================TestCase-3 Update User====================");


		Response res = RestAssured.given().header("Authorization", "Bearer " + pdata.getToken()).contentType("application/json")
				.body(pdata).when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
		System.out.println(res.asPrettyString());

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Status Code is not matched");
		System.out.println("Status Code is 200");

		String actualStatusMessage = res.statusLine();
		Assert.assertTrue(actualStatusMessage.contains("OK"), "Status message is matched");
		System.out.println("Status Message is OK");
	}
}

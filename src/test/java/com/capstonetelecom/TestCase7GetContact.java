package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase7GetContact {
	@Test
	public void getContact(UserPojo pdata) {

		System.out.println("==================TestCase-7 Get Contact====================");

		Response res = RestAssured.given().header("Authorization", "Bearer " + pdata.getToken()).contentType("application/json")
				.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts/" + pdata.getUserId());

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Status code not matched");
		System.out.println("Status Code is 200");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("OK"), "Status message is not matched");
		System.out.println("Status message is - OK");

	}
}

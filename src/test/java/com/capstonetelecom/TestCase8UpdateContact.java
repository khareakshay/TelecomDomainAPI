package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase8UpdateContact {
	@Test
	public void putUpadteContact(UserPojo pdata) {

		System.out.println("==================TestCase-8 Put Update Contact====================");

		Response res = RestAssured.given().header("Authorization", "Bearer " + pdata.getToken()).contentType("application/json")
				.body(pdata).when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/" + pdata.getUserId());

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Status code not matched");
		System.out.println("Status Code is 200");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("OK"), "Status message is not matched");
		System.out.println("Status message is - OK");

		String actualEmail = res.getBody().jsonPath().getString("email");
		Assert.assertTrue(actualEmail.contains("jdoe@fake1254.com"), "Email Not Matched");
		System.out.println("Email Matched-"+actualEmail);

	}
}

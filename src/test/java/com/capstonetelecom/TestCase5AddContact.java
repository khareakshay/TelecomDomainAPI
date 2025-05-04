package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase5AddContact {
	@Test
	public String postAddContact(UserPojo pdata) {

		System.out.println("==================TestCase-5 Add Contact====================");

		Response res = RestAssured.given().header("Authorization", "Bearer " + pdata.getToken()).contentType("application/json")
				.body(pdata).when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 201, "Status code not matched");
		System.out.println("Status Code is 201");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("Created"), "Status message is not matched");
		System.out.println("Status message is - Created");

		String newUserID = res.getBody().jsonPath().getString("_id");
		System.out.println("id - " + newUserID);
		return newUserID;
	}
}

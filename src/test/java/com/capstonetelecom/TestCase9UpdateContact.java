package com.capstonetelecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase9UpdateContactName {
	@Test
	public void patchUpdateContact(UserPojo pdata) {

		System.out.println("==================TestCase-9 Patch Update Contact====================");

		String url = "https://thinking-tester-contact-list.herokuapp.com/contacts/" + pdata.getUserId();
		System.out.println(url);
		Response res = RestAssured.given().header("Authorization", "Bearer " + pdata.getToken()).contentType("application/json")
				.body("{\n" + "\"firstName\": \"Aditya5\"\n" + "}").when().patch(url);

		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Status code not matched");
		System.out.println("Status Code is 200");

		String actualStatusMessage = res.getStatusLine();
		Assert.assertTrue(actualStatusMessage.contains("OK"), "Status message is not matched");
		System.out.println("Status message is - OK");

		String firstName = res.getBody().jsonPath().getString("firstName");
		System.out.println("firstName : " + firstName);
		Assert.assertTrue(firstName.equalsIgnoreCase("Aditya5"), "firstName Not Matched");
		System.out.println("firstName Matched-"+firstName);

	}
}

package com.capstonetelecom;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstonetelecom.pojo.UserPojo;

public class MyMainClass {

	public static String token;
	public static String userId;

	UserPojo pdata;

	@BeforeMethod
	private void tokenGen() {
		pdata = new UserPojo();
		pdata.setToken(token);
		pdata.setUserId(userId);
	}

	@Test(priority = 1)
	public void addNewUser() {
		pdata.setFirstName("Test");
		pdata.setLastName("User");
		pdata.setEmail("test2@fake1264.com");
		pdata.setPassword("myPassword");
		TestCase1AddNewUser addNewUser = new TestCase1AddNewUser();
		token = addNewUser.postNewUser(pdata);
	}

	@Test(priority = 2)
	public void getUserProfile() {
		TestCase2GetUserProfile getUser = new TestCase2GetUserProfile();
		getUser.getUserProfile(pdata);
	}

	@Test(priority = 3)
	public void updateUser() {
		pdata.setFirstName("Updated");
		pdata.setLastName("Username");
		pdata.setEmail("test2@fake1264.com");
		pdata.setPassword("myNewPassword");

		TestCase3UpdateUser upDateUser = new TestCase3UpdateUser();
		upDateUser.patchUpdateUser(pdata);

	}

	@Test(priority = 4)
	public void logInUser() {
		pdata.setEmail("test2@fake1264.com");
		pdata.setPassword("myNewPassword");
		TestCase4LogInUser logInUser = new TestCase4LogInUser();
		token = logInUser.postLoginUser(pdata);
	}

	@Test(priority = 5)
	public void addContact() {
		pdata.setFirstName("Akshay");
		pdata.setLastName("Khare");
		pdata.setBirthdate("1970-01-01");
		pdata.setEmail("jdoe@fake1254.com");
		pdata.setPhone("8005555567");
		pdata.setStreet1("1 Main St.");
		pdata.setStreet2("Apartment A");
		pdata.setCity("Anytown");
		pdata.setStateProvince("KS");
		pdata.setPostalCode("12345");
		pdata.setCountry("USA");

		TestCase5AddContact addContact = new TestCase5AddContact();
		userId = addContact.postAddContact(pdata);
	}

	@Test(priority = 6)
	public void getContactList() {
		TestCase6GetContactList getContactList = new TestCase6GetContactList();
		getContactList.getContactList(pdata);
	}

	@Test(priority = 7)
	public void getContact() {
		TestCase7GetContact getContact = new TestCase7GetContact();
		getContact.getContact(pdata);
	}

	@Test(priority = 8)
	public void upDateContact() {
		pdata.setFirstName("Aditya");
		pdata.setLastName("Khare");
		pdata.setBirthdate("1970-01-01");
		pdata.setEmail("jdoe@fake1254.com");
		pdata.setPhone("8005555567");
		pdata.setStreet1("1 Main St.");
		pdata.setStreet2("Apartment B");
		pdata.setCity("Newtown");
		pdata.setStateProvince("KS");
		pdata.setPostalCode("56789");
		pdata.setCountry("India");

		TestCase8UpdateContact upDateContact = new TestCase8UpdateContact();
		upDateContact.putUpadteContact(pdata);
	}

	@Test(priority = 9)
	public void upDateContactAgain() {
		TestCase9UpdateContactName upDateContactAgain = new TestCase9UpdateContactName();
		upDateContactAgain.patchUpdateContact(pdata);
	}

	@Test(priority = 10)
	public void logoutUser() {
		TestCase10LogoutUser logoutUser = new TestCase10LogoutUser();
		logoutUser.postLogoutUser(token);
	}

}

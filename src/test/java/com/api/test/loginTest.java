package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class loginTest {

	@Test(description="Verify if login Test is working....")
	public void loginTest() {
		AuthService authservice = new AuthService();
		/*
		 * Response response = authservice.login("{\r\n" +
		 * "  \"username\": \"string\",\r\n" + "  \"password\": \"string\"\r\n" + "}");
		 * System.out.println(response.asPrettyString());
		 */
		
	}
}

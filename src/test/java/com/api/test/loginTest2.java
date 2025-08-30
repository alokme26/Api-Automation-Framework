package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;

import io.restassured.response.Response;

public class loginTest2 {

	@Test(description="Verify if login Test is working....")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("string","string");
		AuthService authservice = new AuthService();
		Response response = authservice.login(loginRequest);
		System.out.println(response.asPrettyString());
		
	}
}

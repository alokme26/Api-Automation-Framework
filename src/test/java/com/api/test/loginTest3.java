package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResonse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class loginTest3 {

	@Test(description="Verify if login Test is working....")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("string","string");
		AuthService authservice = new AuthService();
		Response response = authservice.login(loginRequest);
		
		LoginResonse loginResonse =response.as(LoginResonse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResonse.getToken());
		System.out.println(loginResonse.getEmail());
		System.out.println(loginResonse.getId());
		System.out.println(loginResonse.getRoles());
		
		Assert.assertTrue(loginResonse.getToken() != null);
		Assert.assertEquals(loginResonse.getId(), 38);
		Assert.assertEquals(loginResonse.getEmail(), "Hakim@example.com");
		
		
		
		
		
		
	}
	

}

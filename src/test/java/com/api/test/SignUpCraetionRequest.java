package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

//Advantage of using Builder class - Paramater can be use in any sequence


public class SignUpCraetionRequest {


	@Test(description="Verify if signup Test is working....")
	public void signUpCreateAccountTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("Alok12")
				.email("alokme@gmail.com")
				.firstName("Alok1")
				.password("Alok@45612")
				.lastName("Ranjania")
				.mobileNumber("74447852555")
				.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 500);
	}
}

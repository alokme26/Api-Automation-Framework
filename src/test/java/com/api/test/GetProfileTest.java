package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResonse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileTest {
	
	@Test
	public void getProfilleTest() {
		AuthService authservice = new AuthService();
		Response response = authservice.login(new LoginRequest("string","string"));
		LoginResonse loginResonse =response.as(LoginResonse.class);
	
		System.out.println(loginResonse.getToken());
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResonse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
	}

}

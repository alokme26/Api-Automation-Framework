package com.api.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.ProfileRequest;
import com.api.model.response.LoginResonse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void getProfileTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("string","string"));
		LoginResonse loginResonse =response.as(LoginResonse.class);
		System.out.println(response.asPrettyString());

		System.out.println("--------------------------");

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response =	userProfileManagementService.getProfile(loginResonse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertEquals(userProfileResponse.getUsername(), "string");
		System.out.println("-----------------------------------");

		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Aman")
				.lastName("Raj")
				.email("aman@gmail.com")
				.mobileNumber("4747852545")
				.build();

		response = userProfileManagementService.updateProfile(loginResonse.getToken(), profileRequest);

		System.out.println(response.asPrettyString());
	}

}

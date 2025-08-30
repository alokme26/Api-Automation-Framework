package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
// using static import give more readability
public class LoginApiTest {
	
	@Test
	public void loginAptTest() {
		
		//Specify url =  'http://64.227.160.186:8080/api/auth/login'
		
		Response response =  given()
		  .baseUri("http://64.227.160.186:8080")
		  .basePath("/api/auth/login")
		  .contentType(ContentType.JSON)
		  .body("{\r\n"
		  		+ "  \"username\": \"string\",\r\n"
		  		+ "  \"password\": \"string\"\r\n"
		  		+ "}")
		 . post();
		 System.out.println(response.asPrettyString());
		 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}

}

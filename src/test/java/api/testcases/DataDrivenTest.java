package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {

	@Test(priority = 1,dataProvider = "AllData",dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId,String uName, String fName, String lName, String email, String pwd, String phone) {

		User userpayload = new User();
		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(uName);
		userpayload.setFirstName(fName);
		userpayload.setLastName(lName);
		userpayload.setEmail(email);
		userpayload.setPassword(pwd);
		userpayload.setPhone(phone);
		
		Response response = UserEndpoints.createUser(userpayload);

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	@Test(priority = 2,dataProvider = "userNameData",dataProviderClass = DataProviders.class)

	public void testGetUserData(String userName) {

		Response response = UserEndpoints.getUser(userName);

		System.out.println("Read User Data");

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	
	@Test(priority = 4,dataProvider = "userNameData",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) {

		Response response = UserEndpoints.deleteUser(userName);

		System.out.println("Delete User Data");

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
}

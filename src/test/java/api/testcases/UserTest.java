package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userpayload;

	@BeforeClass
	public void geberateTestData() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testCreateUser() {

		Response response = UserEndpoints.createUser(userpayload);

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2)
	public void testGetUserData() {

		Response response = UserEndpoints.getUser(this.userpayload.getUsername());

		System.out.println("Read User Data");

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3)
	public void testUpdateUser() {

		userpayload.setUsername(faker.name().username());

		Response response = UserEndpoints.updateUser(this.userpayload.getUsername(),userpayload);

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

		//Read user data to check if first name is updated
		Response responsePostUpdate = UserEndpoints.getUser(this.userpayload.getUsername());

		System.out.println("Update User Data");
		
		responsePostUpdate.then().log().all();


	}

	@Test(priority = 4)
	public void testDeleteUser() {

		Response response = UserEndpoints.deleteUser(this.userpayload.getUsername());

		System.out.println("Delete User Data");

		//Log response
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}


}

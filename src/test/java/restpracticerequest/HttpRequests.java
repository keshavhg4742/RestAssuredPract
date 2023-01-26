package restpracticerequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequests {
	int id;
	
	@Test(priority = 1)
	public void getRequest() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
		
	}
	@Test(priority = 2)
	public void postRequest() {
		HashMap data = new HashMap();
		data.put("name", "morph");
		data.put("job", "eader");
		
		id=given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		/*.then()
			/*.statusCode(201)
			.log().all();*/
		System.out.println("generated id is "+id);
	}
	@Test(priority = 3,dependsOnMethods ="postRequest" )
	public void updateRequest() {
		HashMap data = new HashMap<>();
		data.put("name", "aandy");
		data.put("job", "ccc");
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	

}

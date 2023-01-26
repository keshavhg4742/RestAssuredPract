package typesofpostrequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class PostReqUsingExternalJSON {
	
	@Test
	public void externalJSON() throws FileNotFoundException {
		
		FileReader file = new FileReader("./my.json");
		JSONTokener jsonTokener = new JSONTokener(file);		
		JSONObject data = new JSONObject(jsonTokener);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("praj"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all()
		;
		
		
	}

}

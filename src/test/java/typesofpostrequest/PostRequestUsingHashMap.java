package typesofpostrequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PostRequestUsingHashMap {
	
	@Test
	public void postUsingHashMap() {
	HashMap	data=new HashMap();
	
	data.put("name", "nir");
	data.put("location", "bgm");
	data.put("phone", "98765");
	
	String courcesArry[]= {"json","jee"};
	data.put("cources", courcesArry);
	
	given()
		.contentType("application/json")
		.body(data)
	.when()
		.post("http://localhost:3000/student")
		
		
	.then()
		.statusCode(201)
		.body("name",equalTo("nir"))
		.body("cources[0]", equalTo("json"))
		.log().all();
	
		
	}
	

}

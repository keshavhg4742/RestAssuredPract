package typesofpostrequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostReqUsingJSONObject {
	
	//using ORG.JSON
	@Test
	public void postUsingJsonObj() {
		
		JSONObject data = new JSONObject();
		data.put("name", "keshav");
		data.put("location", "sbc");
		data.put("phone", "45678");
		String courcesarr[]= {"java","sele"};
		data.put("cources", courcesarr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.body("name", equalTo("keshav"))
			.log().all()
			.header("Content-Type", "application/json; charset=utf-8");
			
		
	}

}

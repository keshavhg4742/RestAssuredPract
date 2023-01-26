package typesofpostrequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import pojoclasses.PojoClass;

public class PostReqUsingPOJO {
	
	@Test
	public void requestUsingPojo() {
		PojoClass data = new PojoClass();
		String cource[]= {"linux","testing"};
		data.setName("vignesh");
		data.setLocation("bgm");
		data.setCources(cource);
		data.setPhone("1234567");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("vignesh"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	}

}

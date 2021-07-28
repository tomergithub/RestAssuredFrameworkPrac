package functionTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostRequestAutomation {
@Test
public void postAPiAutomation() {
	RestAssured.baseURI="https://reqres.in/api/users";
	String json="{\n"+
	"\"name\":\"Fun Doo Testers\", \n"+
			"\"job\":\"SDET\"\n"+
	"}";
	RestAssured.given().body(json)
	.post()
	.then()
	.log()
	.all()
	.assertThat().
	statusCode(201);
	
	/*RestAssured.given().body("{\n"+
	"\"name\":\"Fun Doo Testers\", \n"+
			"\"job\":\"SDET\"\n"+
	"}").post().then().log().all().assertThat().statusCode(201);
	*/
}
}

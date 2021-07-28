package studentApiTest;

//import org.json.JSONArray;
//import org.json.JSONObject;
import org.testng.annotations.Test;

//import com.google.gson.JsonArray;
import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITests extends BaseTest {
	// json-server --watch db.json
	@Test
	public void getAPITest() {
		// RestAssured.given().when().get(APIPath.apiPath.GetListOfPosts).then().log().all().statusCode(200);
		test.log(LogStatus.INFO, "My test is starting.....");
		Response response = RestAssured.given().when().get(APIPath.apiPath.GetListOfPosts);
		APIVerification.responseCodeValidation(response, 200);
		APIVerification.responseTimeValidation(response);
		APIVerification.responseKeyValidationfromArray(response, "title");
		System.out.print(response.getBody().asString());
		test.log(LogStatus.PASS, "My test ended..");
		
		
		/*
		 * //test.log(LogStatus.INFO, response.getBody().asString());
		 * //test.log(LogStatus.INFO,"My status code is " +response.getStatusCode());
		 * //test.log(LogStatus.INFO,"REsponse time is " + response.getTime());
		 * 
		 * 
		 * JSONArray array = new JSONArray(response.getBody().asString()); for (int i=0;
		 * i<array.length();i++) { //System.out.print(array.get(i)); JSONObject obj =
		 * array.getJSONObject(i); test.log(LogStatus.INFO,
		 * "Validated values are "+obj.get("title"));
		 * System.out.print(obj.get("title")); test.log(LogStatus.PASS,
		 * "My test passed.."); test.log(LogStatus.PASS, "My test ended.."); }
		 * 
		 */

	}
}

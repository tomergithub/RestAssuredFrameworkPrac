package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
//import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.LogStatus;

//import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {
	public static void responseCodeValidation(Response response, int statusCode) {
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS, "Suceessfully validated status code,status code is:: " + response.getStatusLine());

		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"Expected status code is:: " + statusCode + ", instead of getting :: " + response.getStatusCode());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	public static void responseKeyValidationfromArray(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for (int i = 0; i < array.length(); i++) {
				//System.out.print(array.get(i));
				JSONObject obj = array.getJSONObject(i);
				//Assert.assertEquals(key, obj.get(key));
				test.log(LogStatus.PASS, "Validated values are " + obj.get(key));
				//System.out.print(obj.get("title"));
				// test.log(LogStatus.PASS, "My test passed..");
				// test.log(LogStatus.PASS, "My test ended..");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void responseKeyValidationfromJsonObject(Response response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			
			if(json.has(key) && json.get(key)!=null){
			test.log(LogStatus.PASS,"Successfully validated value of " +key + " It is " +json.get(key));
			
			}else {
				test.log(LogStatus.FAIL, "Key is not available ");
			}		
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	public static void responseTimeValidation(Response response) {
		try {
			long time = response.time();
			test.log(LogStatus.INFO, "Api response time is :: " + time);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
}

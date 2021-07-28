package studentApiTest;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtils;

public class PostAPITest extends BaseTest{
@Test
public void validpostAPITest() {
test.log(LogStatus.INFO, "My test is starting....... ");
	
	HeaderConfigs header=new HeaderConfigs();
	PostAPIBuilder builder=new PostAPIBuilder();
	
	
	Response response=RestAssured.given().when().headers(header.defaultHeaders())
			.body(builder.postRequestBody(JavaUtils.randomNumber(), JavaUtils.randomString(), JavaUtils.randomString()))
			.when().post(APIPath.apiPath.CreatePost);
	
	APIVerification.responseKeyValidationfromJsonObject(response,"title");
	APIVerification.responseCodeValidation(response, 201);
	APIVerification.responseTimeValidation(response);
	test.log(LogStatus.INFO, "My test is ended....... ");
}
}

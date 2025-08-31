package DataExtractionFromJSon;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

public class mockerExample {
	@Test
	public void mockURl() {
		RestAssured.baseURI="https://b5443324-0a0c-43ed-99db-48219cd53a3c.mock.pstmn.io";
		Response res=given().header("Content-Type","application/json").
				header("x-mock-match-request-body", "true").
				body("[\r\n"
						+ "    {\"id\":\"1000\",\"type\":\"grains\" },\r\n"
						+ "    {\"id\":\"1001\",\"type\":\"beverage\" }\r\n"
						+ "]").
				when().post("/userName").then().extract().response();
		String responseString=res.asPrettyString();
		System.out.println("Response is:"+responseString);
	}
}

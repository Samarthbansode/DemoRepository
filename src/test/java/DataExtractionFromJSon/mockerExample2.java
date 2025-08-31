package DataExtractionFromJSon;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

public class mockerExample2 {
	@Test
	public void mockURl() {
		RestAssured.baseURI="https://b5443324-0a0c-43ed-99db-48219cd53a3c.mock.pstmn.io";
		Response res=given().header("Content-Type","application/json").
				header("x-mock-match-request-body", "true").
				body("{\r\n"
						+ "  \r\n"
						+ "  \"id\": \"0001\",\r\n"
						+ "  \"type\": \"donut\",\r\n"
						+ "  \"name\": \"Cake\",\r\n"
						+ "  \"ppu\": 0.55,\r\n"
						+ "  \"batters\":{\r\n"
						+ "    \"batter\":[\r\n"
						+ "        { \"id\": \"1001\", \"type\": \"Regular\" },\r\n"
						+ "        { \"id\": [\r\n"
						+ "          5,9\r\n"
						+ "        ], \"type\": \"Chocolate\" }\r\n"
						+ "    ]\r\n"
						+ "  },\r\n"
						+ "    \"topping\":[\r\n"
						+ "\r\n"
						+ "      {\"id\": \"5001\", \"type\": \"None\"},\r\n"
						+ "      {\"id\": \"5002\", \"type\": \"Glazed\" },\r\n"
						+ "      {\"id\": \"sees\", \"type\": \"Sugar\"}\r\n"
						+ "]}").log().all().
				when().post("/userNameComplex").then().extract().response();
		String responseString=res.asPrettyString();
		System.out.println("Response is:"+responseString);
	}
}

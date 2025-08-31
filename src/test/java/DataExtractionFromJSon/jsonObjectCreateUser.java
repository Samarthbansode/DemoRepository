package DataExtractionFromJSon;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class jsonObjectCreateUser {
	@Test
	public void Create() {
		HashMap<String , String >obj = new HashMap<String , String>();
		obj.put("name", "Samarth");
		obj.put("job", "Tester");
		RestAssured.baseURI = "https://reqres.in";
		Response response = given().body(obj).header("Content-Type","application/json").log().all().
				when().post("/api/users").then().extract().response();
		System.out.println(response.asPrettyString());

	}
}



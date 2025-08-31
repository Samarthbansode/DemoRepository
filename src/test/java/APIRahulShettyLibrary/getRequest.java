package APIRahulShettyLibrary;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class getRequest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		Response response = given().queryParam("page", "2").log().all().when().get("api/users").then().assertThat().statusCode(100).extract().response();
		//System.out.println("Response "+response.asPrettyString());
		//System.out.println("Status Code: "+response.statusCode());
		//System.out.println(response.headers());
		
	}

}

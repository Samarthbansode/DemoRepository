package DataExtractionFromJSon;
import org.apache.http.message.BasicHeader;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.outerAlternative_return;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class SingleUser {
	
	@Test
	public void complex() {
		RestAssured.baseURI = "https://reqres.in/";
		Response response = given().when().get("api/users/3").then().extract().response();
		System.out.println(response.asPrettyString());
		String mailId = response.jsonPath().getString("data.email");
		System.out.println("Mail id is : "+mailId);
	}
}

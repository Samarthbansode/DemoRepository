package Practice;
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
		System.out.println("Status Code  : " +response.statusCode());
		System.out.println("Status Line  : "+response.statusLine());
		System.out.println("Response Time   : "+response.time());
		//Headers List
		Headers allHeaders = response.headers();
		List<Header> listOfheaders = allHeaders.asList();
		for(Header list:listOfheaders) {
			System.out.println(list);
		}
		//Or
		System.out.println("Response Header   : "+response.headers());
		//Or
		System.out.println("Response Header   : "+response.getHeaders());
		
		//Single Header
		System.out.println("Header Content-Type   : "+response.header("Content-Type"));
		//Or
		System.out.println("Header Content-Type   : "+response.getHeader("Content-Type"));
		
		
	}
}

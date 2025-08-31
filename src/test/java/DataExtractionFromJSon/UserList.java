package DataExtractionFromJSon;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserList {
	
	@Test
	public void complex() {
		RestAssured.baseURI = "https://reqres.in/";
		Response response = given().when().get("api/users?page=2").then().extract().response();
		System.out.println(response.asPrettyString());
		int data = response.jsonPath().getInt("data.size()");
		String latName = response.jsonPath().getString("data[0].last_name");
		System.out.println("latName : "+latName);
		for(int i=0; i<data; i++) {
			String latNames = response.jsonPath().getString("data["+i+"].last_name");
			System.out.println("lastNames "+i+ latNames);
		}
	}

}

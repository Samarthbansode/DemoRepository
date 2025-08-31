package Practice;
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
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
	}

}

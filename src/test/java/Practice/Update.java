package Practice;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Update {
	
	@Test
	public void complex() {
		RestAssured.baseURI = "https://reqres.in/";
		Response response = given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").header("Content-Type","application/json").when().put("api/users/2").then().extract().response();
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
	}

}

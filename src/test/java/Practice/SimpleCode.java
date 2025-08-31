package Practice;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class SimpleCode {	
	@Test
	public void simple() {
		RestAssured.baseURI = "https://reqres.in/";
		Response response=given().log().all().when().get("api/users?page=2").then().log().all().extract().response();
	}
}

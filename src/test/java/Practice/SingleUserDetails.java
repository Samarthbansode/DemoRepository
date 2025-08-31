package Practice;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class SingleUserDetails {
	@Test
	public void complex() {
		RestAssured.baseURI = "https://reqres.in/";
		Response response = given().log().all().when().get("api/users/3").then().assertThat().body("data.first_name", equalTo("Emma")).header("Server", "cloudflare").extract().response();
	}
}

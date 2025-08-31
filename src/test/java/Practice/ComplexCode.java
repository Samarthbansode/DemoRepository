package Practice;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ComplexCode {	
	@Test
	public void complex() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification requestSpe = RestAssured.given();
		RequestSpecification requestSpec = requestSpe.when();
		Response requestSpeci = requestSpec.get("api/users?page=2");
		Response response = requestSpeci.then().extract().response();
		System.out.println(response.asPrettyString());
	}
}

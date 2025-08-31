package DataExtractionFromJSon;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserCreateSwagger {
	//https://petstore.swagger.io/#/user/createUser
	@Test
	public void Create() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		Response response = given().body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"username\": \"Sam\",\r\n"
				+ "  \"firstName\": \"Samarth\",\r\n"
				+ "  \"lastName\": \"Bansode\",\r\n"
				+ "  \"email\": \"Abc@gmail.com\",\r\n"
				+ "  \"password\": \"pas@10\",\r\n"
				+ "  \"phone\": \"1234567890\",\r\n"
				+ "  \"userStatus\": 1\r\n"
				+ "}").header("Content-Type","application/json").header("accept","application/json").when().post("v2/user").then().extract().response();
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		int code= response.jsonPath().getInt("code");
		System.out.println("Code Value is : "+code);
		String message= response.jsonPath().getString("message");
		System.out.println("message Value is : "+message);
	}

}

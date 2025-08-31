package Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Login {
	@Test
	public void post() {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		LoginRequestPojo objrequest = new LoginRequestPojo();
		objrequest.userEmail= "testers@gamil.com";
		objrequest.userPassword = "Samarth@25";
		LoginReponsePojo responseObj = given().body(objrequest).header("Content-Type","application/json").log().all().
				when().post("api/ecom/auth/login").then().log().all().extract().response().as(LoginReponsePojo.class);
		CommonHelper.token = responseObj.getToken();
		CommonHelper.userId = responseObj.getUserId();
		CommonHelper.message = responseObj.getMessage();
	}
}

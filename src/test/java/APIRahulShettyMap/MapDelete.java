package APIRahulShettyMap;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import File.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MapDelete {
	@Test
	public void post() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String res = given().queryParam("key", "qaclick123")
				.body(PayLoad.Delete())
				.delete("/maps/api/place/delete/json").
				then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				String status = objRes.getString("status");
				Assert.assertEquals(status, "OK");
	}
}

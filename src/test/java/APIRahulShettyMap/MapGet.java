package APIRahulShettyMap;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import File.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MapGet {
	@Test
	public void post() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String res = given().queryParam("place_id", PayLoad.Place_Id).
				queryParam("key", "qaclick123")
				.get("maps/api/place/get/json").
				then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				String Addr = objRes.getString("address");
				Assert.assertEquals(Addr, PayLoad.Addr);
	}
}

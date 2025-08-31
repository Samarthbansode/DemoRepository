package APIRahulShettyMap;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import File.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MapPut {
	@Test
	public void post() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String res = given().queryParam("place_id", PayLoad.Place_Id).queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(PayLoad.putPlace()).when()
				.put("/maps/api/place/update/json").then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				String Mssg = objRes.getString("msg");
				Assert.assertEquals(Mssg, "Address successfully updated");
	}
}

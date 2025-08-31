package APIRahulShettyMap;

import org.testng.annotations.Test;
import File.PayLoad;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class MapPost {
	@Test
	public void post() {
		List<String> objType = new ArrayList<String>();
		objType.add("shoe park");
		objType.add("shop");
		
		HashMap<String, Object> objLoca = new HashMap<String, Object>();
		objLoca.put("lat", -38.383494);
		objLoca.put("lng", 33.427362);
		
		HashMap<String, Object> objMain = new HashMap<String, Object>();
		objMain.put("location", objLoca);
		objMain.put("accuracy", 50);
		objMain.put("name", "Frontline house");
		objMain.put("phone_number", "(+91) 983 893 3937");
		objMain.put("address", "29, side layout, cohen 09");
		objMain.put("types", objType);
		objMain.put("website", "http://google.com");
		objMain.put("language", "French-IN");
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String res = given().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(objMain).log().all().when()
				.post("/maps/api/place/add/json").then().extract().response().asPrettyString();
		JsonPath ojRes = new JsonPath(res);
		String place_id = ojRes.getString("place_id");
		System.out.println("Place_Id is : " + place_id);
		PayLoad.Place_Id= place_id;
	}
}

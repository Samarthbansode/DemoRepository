package APIRahulShettyMap;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
public class MapPostUsingSerDe {
	@Test
	public void post() {
		MapPostPojoReqMain objMain = new MapPostPojoReqMain();
		Location location = new Location();
		location.setLat(-38.383494) ;
		location.setLng(33.427362);
		objMain.setLocation(location);
		objMain.accuracy = 50;
		objMain.name = "Frontline house";
		objMain.phone_number = "(+91) 983 893 3937";
		objMain.address = "29, side layout, cohen 09";
		 List<String> typesList = new ArrayList<>();
	        typesList.add("shoe park");
	        typesList.add("shop");
	    objMain.setTypes(typesList);
		objMain.website = "http://google.com";
		objMain.language = "language";
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		 MapPostPojoResponse res = given().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(objMain).log().all().when()
				.post("/maps/api/place/add/json").then().extract().response().as(MapPostPojoResponse.class);
		System.out.println(res.getStatus());
		System.out.println(res.getId());
		System.out.println(res.getPlace_id());
		System.out.println(res.getReference());
		System.out.println(res.getScope());
		System.out.println(res.getClass());
		
	}
}

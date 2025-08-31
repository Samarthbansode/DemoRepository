package DataExtractionFromJSon;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
public class mockerExampleObject {
	@Test
	public void mockURl() {
		HashMap<String,String> objind1= new HashMap<String, String>();
		objind1.put("id", "1000");
		objind1.put("type", "grains");
		HashMap<String,String> objind2= new HashMap<String, String>();
		objind2.put("id", "1001");
		objind2.put("type", "beverage");
		List<HashMap<String,String> > objlist = new ArrayList<HashMap<String,String>>();
		objlist.add(objind1);
		objlist.add(objind2);
		RestAssured.baseURI="https://b5443324-0a0c-43ed-99db-48219cd53a3c.mock.pstmn.io";
		Response res=given().header("Content-Type","application/json").
				header("x-mock-match-request-body", "true").
				body(objlist).log().all().
				when().post("/userName").then().log().all()
				.extract().response();
		String responseString=res.asPrettyString();
		System.out.println("Response is:"+responseString);
	}
}

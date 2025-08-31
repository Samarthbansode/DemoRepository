package DataExtractionFromJSon;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.groovy.util.ObjectHolder;
import org.testng.annotations.Test;
public class mockerExampleObject2 {
	@Test
	public void mockURl() {
		List<Integer> obj = new ArrayList<Integer>();
		obj.add(5);
		obj.add(9);
		HashMap<String,Object> objbatter1= new HashMap<String, Object>();
		objbatter1.put("id", "1001");
		objbatter1.put("type", "Regular");
		HashMap<String,Object> objbatter2= new HashMap<String, Object>();
		objbatter2.put("id", obj);
		objbatter2.put("type", "Chocolate");
		List<HashMap<String,Object> > objbatterArray = new ArrayList<HashMap<String,Object>>();
		objbatterArray.add(objbatter1);
		objbatterArray.add(objbatter2);
		HashMap<String,List<HashMap<String,Object> >> objbatter= new HashMap<String, List<HashMap<String,Object> >>();
		objbatter.put("batter", objbatterArray);
		
		HashMap<String,String> objtop0= new HashMap<String, String>();
		objtop0.put("id", "5001");
		objtop0.put("type", "None");
		HashMap<String,String> objtop1= new HashMap<String, String>();
		objtop1.put("id", "5002");
		objtop1.put("type", "Glazed");
		HashMap<String,String> objtop2= new HashMap<String, String>();
		objtop2.put("id", "5003");
		objtop2.put("type", "Sugar");
		List<HashMap<String,String> > objTopArray = new ArrayList<HashMap<String,String>>();
		objTopArray.add(objtop0);
		objTopArray.add(objtop1);
		objTopArray.add(objtop2);
		
		LinkedHashMap<String,Object> objFinal= new LinkedHashMap<String, Object>();
		objFinal.put("id", "001");
		objFinal.put("type", "donut");
		objFinal.put("name", "Cake");
		objFinal.put("ppu", 0.55);
		objFinal.put("batters", objbatter);
		objFinal.put("topping", objTopArray);
		
		
		
		RestAssured.baseURI="https://b5443324-0a0c-43ed-99db-48219cd53a3c.mock.pstmn.io";
		Response res=given().header("Content-Type","application/json").
				header("x-mock-match-request-body", "true").
				body(objFinal).log().all().
				when().post("/userNameComplex").then().log().all()
				.extract().response();
		String responseString=res.asPrettyString();
		System.out.println("Response is:"+responseString);
	}
}

package DataExtractionFromJSon;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;


public class jsonClass {
	@Test
	public void extractdata() {
		String json ="{\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"id\": 3,\r\n"
				+ "        \"email\": \"emma.wong@reqres.in\",\r\n"
				+ "        \"first_name\": \"Emma\",\r\n"
				+ "        \"last_name\": \"Wong\",\r\n"
				+ "        \"avatar\": \"https://reqres.in/img/faces/3-image.jpg\"\r\n"
				+ "    },\r\n"
				+ "    \"support\": {\r\n"
				+ "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\r\n"
				+ "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "";
		JsonPath jsondata=new JsonPath(json);
		System.out.println(jsondata.getString("data.email"));
		
	}

}

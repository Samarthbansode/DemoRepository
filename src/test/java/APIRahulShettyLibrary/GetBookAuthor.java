package APIRahulShettyLibrary;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import File.LibraryPayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetBookAuthor {
	@Test(dataProvider = "bookData")
	public void post() {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().get("Library/GetBook.php?AuthorName="+LibraryPayLoad.Author).
				then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				System.out.println("Response Get Author: "+res);
	}
}

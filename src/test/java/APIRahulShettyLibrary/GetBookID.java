package APIRahulShettyLibrary;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import File.LibraryPayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class GetBookID {
	String author = "";
	@Test(dataProvider = "bookData")
	public void post() {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().when().get("Library/GetBook.php?ID="+LibraryPayLoad.Book_Id).
				then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				author = objRes.getString("[0].author");
				LibraryPayLoad.Author = author;
				System.out.println("Response Get ID: "+res);
	}
}
package APIRahulShettyLibrary;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import File.LibraryPayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddBook {
	String Book_Id  ="";
	@Test
	public void post() {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().header("Content-Type","application/json").body(LibraryPayLoad.libraryPost("Sam","1234556790"))
				.post("Library/Addbook.php").
				then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				Book_Id = objRes.getString("ID");
				LibraryPayLoad.Book_Id =Book_Id;
				System.out.println("Response Add Book : "+res);
	}
	
}
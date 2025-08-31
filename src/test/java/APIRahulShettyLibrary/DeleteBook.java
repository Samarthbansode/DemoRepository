package APIRahulShettyLibrary;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import File.LibraryPayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DeleteBook {
	String author = LibraryPayLoad.Author;
	@Test(dataProvider = "bookData")
	public void post() {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().body(LibraryPayLoad.LibraryDelete()).delete("Library/DeleteBook.php").
				then().extract().response().asPrettyString();
				System.out.println("Response Delete : "+res);
	}
}



package APIRahulShettyLibrary;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import File.LibraryPayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddBookBodyfromFile {
	String Book_Id  ="";
	@Test
	public void post() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().header("Content-Type","application/json").body(body("C:\\Users\\Admin\\Documents\\body.Json"))
				.post("Library/Addbook.php").
				then().extract().response().asPrettyString();
				JsonPath objRes = new JsonPath(res);
				Book_Id = objRes.getString("ID");
				LibraryPayLoad.Book_Id =Book_Id;
				System.out.println("Response Add Book : "+res);
	}
	public static String body(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get("C:\\Users\\Admin\\Documents\\body.Json")));
	}
}

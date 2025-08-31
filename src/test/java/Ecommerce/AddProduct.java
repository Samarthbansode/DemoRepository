package Ecommerce;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;
public class AddProduct extends CommonHelper {
	@Test
	public void post() {
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\Image.png";
		File file = new File(path);
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		AddProductResponsePojo response = given().log().all().param("productName", "Lewis Jeans").param("productAddedBy", userId)
		.param("CommonHelper", "Fashion").param("productSubCategory", "Trooser")
		.param("productPrice", "2000").param("productDescription", "Lewis")
		.param("productFor", "Men").multiPart("productImage", file).header("Authorization",token).when().post("api/ecom/product/add-product").
		then().log().all().extract().as(AddProductResponsePojo.class);
		productId = response.getProductId();
		AddPromessage = response.getMessage();
	}

}

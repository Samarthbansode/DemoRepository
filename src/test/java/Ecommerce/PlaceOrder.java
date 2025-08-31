package Ecommerce;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
public class PlaceOrder extends CommonHelper {
	@Test
	public void post() {
		PlaceOrderRequestPojo obj = new PlaceOrderRequestPojo();
		obj.country = "India";
		obj.productOrderedId = productId;
		List<PlaceOrderRequestPojo> orders = new ArrayList<PlaceOrderRequestPojo>();
		orders.add(obj);
		HashMap<String, Object> objMain = new HashMap<String, Object>();
		objMain.put("orders", orders);
		
				
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().header("Content-Type","application/json").
				header("Authorization",token).log().all().body(objMain).
				
				when().post("api/ecom/order/create-order").then().log().all().extract().response().asPrettyString();
		System.out.println(response);
				
	}

}

package APIRahulShettyMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import File.PayLoad;
import io.restassured.path.json.JsonPath;
public class DataExtractionJson {
	@Test
	public void extractData() {
		String json = PayLoad.jsonResponse();
		JsonPath objRes = new JsonPath(json);
		
		//Print No of courses returned by API
		int NoOfCourses = objRes.getInt("courses.size()");
		System.out.println("Print No of courses returned by API : "+NoOfCourses );
		
		//Print Purchase Amount
		int  PurchaseAmount = objRes.getInt("dashboard.purchaseAmount");
		System.out.println("Print Purchase Amount : "+PurchaseAmount );
		
		//Print Title of the first course
		String  FirtTitle = objRes.getString("courses[0].title");
		System.out.println("Print Title of the first course : "+FirtTitle );
		
		//Print All course titles and their respective Prices
		int Total = 0 ;
		for(int i=0; i<NoOfCourses; i++) {
			String Course = objRes.getString("courses["+i+"].title");
			System.out.println("Course Title ["+i+"] : "+ Course);
			int price = objRes.getInt("courses["+i+"].price");
			System.out.println("price ["+i+"] : "+ price);
			
			//Print no of copies sold by RPA Course
			if(Course.equalsIgnoreCase("RPA")) {
				String copies = objRes.getString("courses["+i+"].copies");
				System.out.println("RPA copies : "+ copies);
			}
			int copies = objRes.getInt("courses["+i+"].copies");
			System.out.println("copies ["+i+"] : "+ copies);
			int totalforEachCourse = price*copies;
			Total = Total + totalforEachCourse;
		}
		System.out.println("Total Purchase Amount : "+Total);
		Assert.assertEquals(Total, PurchaseAmount);
	}
}


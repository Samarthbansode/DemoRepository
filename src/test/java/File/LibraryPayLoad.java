package File;

public class LibraryPayLoad {
	public static String  Book_Id = "";
	public static String  Author = "";
	public static String libraryPost(String Author, String aisle) {
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"Book\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\""+Author+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String LibraryDelete() {
		return ""
				+ "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+Book_Id+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
	}
}

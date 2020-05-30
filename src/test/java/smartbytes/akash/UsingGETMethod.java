package smartbytes.akash;

import static io.restassured.RestAssured.given;
public class UsingGETMethod {
	private static String hostName = "http://localhost:9090";
	private final static String countryURI= hostName+ "/api/country/country/get/all";
	
	public static void main(String[] args) {
		// make call to country api to read all the countries.
	String sessionId=	given().contentType("application/json;charset=utf-8").
		get("http://dummy.restapiexample.com/api/v1/employee/1").cookie("PHPSESSID");
	
	System.out.println("Session Id:" + sessionId);
	given().contentType("application/json;charset=utf-8").
	sessionId("PHPSESSID", sessionId).
	get("http://dummy.restapiexample.com/api/v1/employee/1").prettyPrint();
	}

}

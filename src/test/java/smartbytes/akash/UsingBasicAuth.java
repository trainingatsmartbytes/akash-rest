package smartbytes.akash;

import static io.restassured.RestAssured.given;
public class UsingBasicAuth {
	 
	public static void main(String[] args) {
	
	
	String auth_token = OAuthUtil.read_token();
	System.out.println("Token :" + auth_token);
	
	given().
	header("Authorization", "Bearer "+auth_token).
	contentType("application/json").
	 log().
	 all().
   get("http://localhost:9091/api/message").
   then().
   		log().
   		all();
	}
}

package smartbytes.akash;

import static io.restassured.RestAssured.given;
public class UsingBasicAuth {
	
	public static void main(String[] args) {
	
//	given().
//		auth().
//		preemptive().
//		basic("admin", "admin").
//		contentType("application/json").
//		pathParam("id", "1").
//		log().
//		all().
//	   get("http://localhost:9090/api/employee/show/{id}").
//	   then().
//	   		log().
//	   		all();
	

	//Generate oAuth 2 Token from token API
	
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

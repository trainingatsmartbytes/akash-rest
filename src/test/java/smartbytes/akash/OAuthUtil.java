package smartbytes.akash;

import static io.restassured.RestAssured.given;

public class OAuthUtil {

	public static String read_token() {
		String auth_token=		
				given().
				auth().
				preemptive().
				basic("smartbytes", "secret").
				formParam("token_name", "access_token").
				formParam("grant_type", "password").
				formParam("username", "admin").
				formParam("password", "admin").
				formParam("scope", "read").
				post("http://localhost:9091/api/oauth/token").
				then().
				statusCode(200).extract().response().path("access_token");
		return auth_token;
	}
}

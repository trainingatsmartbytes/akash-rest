package smartbytes.akash.api.customer;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class ProductAPITest {
	
	public static void main(String[] args) {
		
		String createProductURI = "http://localhost:9090/api/product";
		
		String requestBody = "{\"productId\":\"P-9999\",\"description\":\"Iphone X\",\"price\":1500.00}";
		
		//set the request content type - applicaiton/json
		//set the request body
    Response customerResponse=	given()
						    .contentType(ContentType.JSON)
							.body(requestBody)
							.post(createProductURI)
							.then()
							.statusCode(HttpStatus.SC_CREATED)
							.extract()
							.response();
	customerResponse.prettyPrint();
	}

}

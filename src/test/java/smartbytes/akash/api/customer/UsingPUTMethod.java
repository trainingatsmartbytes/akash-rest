package smartbytes.akash.api.customer;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class UsingPUTMethod {
	
	public static void main(String[] args) {
		
		String updateCustomerURI = "http://localhost:9090/api/customer/update/{customer_id}";
		
		String requestBody = "{\n" + 
				"  \"city\": \"Hyderabad\",\n" + 
				"  \"county\": \"Madhapur\",\n" + 
				"  \"email\": \"akash.m@gmail.com\",\n" + 
				"  \"firstName\": \"Akash-Updated\",\n" + 
				"  \"lastName\": \"Bilthare-Updated\",\n" + 
				"  \"phone1\": \"1234565\",\n" + 
				"  \"phone2\": \"7457458459\",\n" + 
				"  \"state\": \"Telangana\",\n" + 
				"  \"web\": \"www.akash.org\",\n" + 
				"  \"zip\": \"12312\"\n" + 
				"}";
		
  //set the request content type - application/json
	//set the request body
    Response customerResponse=	given()
						    .contentType(ContentType.JSON)
						    .pathParam("customer_id", 480)
							.body(requestBody)
							.put(updateCustomerURI)
							.then()
							.statusCode(HttpStatus.SC_OK)
							.body("email",equalTo("akash.m@gmail.com"))
							.extract()
							.response();
	customerResponse.prettyPrint();
	}

}

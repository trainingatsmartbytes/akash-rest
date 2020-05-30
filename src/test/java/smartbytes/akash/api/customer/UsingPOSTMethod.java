package smartbytes.akash.api.customer;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class UsingPOSTMethod {
	
	public static void main(String[] args) {
		
		String createCustomerURI = "http://localhost:9090/api/customer/add";
		
		String requestBody = "{\n" + 
				"  \"city\" : \"Hyderabad\",\n" + 
				"  \"county\": \"Madhapur\",\n" + 
				"  \"email\": \"akash@gmail.com\",\n" + 
				"  \"firstName\": \"Akash\",\n" + 
				"  \"lastName\": \"Bilthare\",\n" + 
				"  \"phone1\": \"1234565\",\n" + 
				"  \"phone2\": \"7457458459\",\n" + 
				"  \"state\": \"Telangana\",\n" + 
				"  \"web\": \"www.akash.org\",\n" + 
				"  \"zip\": \"12312\"\n" + 
				"}";
		
		//set the request content type - applicaiton/json
		//set the request body
    Response customerResponse=	given()
						    .contentType(ContentType.JSON)
							.body(requestBody)
							.post(createCustomerURI)
							.then()
							.statusCode(HttpStatus.SC_CREATED)
							.body("email", equalTo("akash@gmail.com"))
							.extract()
							.response();
    int customerId = customerResponse.path("id");
    System.out.println("new customer id = " + customerId);
	customerResponse.prettyPrint();
	}

}

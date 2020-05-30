package smartbytes.akash.api.customer;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class UsingDELETEMethod {
	
	public static void main(String[] args) {
		
		String deleteCustomerURI = "http://localhost:9090/api/customer/delete/{customer_id}";
		
	
		//set the request content type - application/json
		//set the request body
    Response customerResponse=	given()
						    .contentType(ContentType.JSON)
						    .pathParam("customer_id", 480)
							.delete(deleteCustomerURI)
							.then()
							.statusCode(HttpStatus.SC_OK)
							.extract()
							.response();
	customerResponse.prettyPrint();
	}

}

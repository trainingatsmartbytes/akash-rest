package smartbytes.akash.api.customer;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public class UsingGETMethod {

	final static RequestSpecification reqSpec = new RequestSpecBuilder()
											  .build()
											  .contentType(ContentType.JSON);
	public static void main(String[] args) {
		String getCustomerURI = "http://localhost:9090/api/customer/show";
		
		 given()
		.spec(reqSpec)
		.queryParam("id", 1)
		.get(getCustomerURI)
		.then()
		.statusCode(HttpStatus.SC_OK)
		.extract()
		.response()
		.prettyPrint();
		
	}
}

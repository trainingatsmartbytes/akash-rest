package smartbytes.akash;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class UsingSpecificationTemplates {
 

final static ResponseSpecification respSpec = new ResponseSpecBuilder().
													build()
													.statusCode(HttpStatus.SC_OK)
													.contentType(ContentType.JSON)
													.body("RestResponse.result.name", equalTo("India"))
													.body("RestResponse.result.alpha2_code", equalTo("IN"))
													.body("RestResponse.result.alpha3_code", equalTo("IND"));
	
	
	
	
	public static void main(String[] args) {
		 get("http://localhost:9090/api/country/get/iso2code/IN").then().spec(respSpec);
		 get("http://localhost:9090/api/country/get/iso3code/IND").then().spec(respSpec);
		System.out.println("Success..");
	}

}

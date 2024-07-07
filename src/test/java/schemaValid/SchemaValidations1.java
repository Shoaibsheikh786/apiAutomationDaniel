package schemaValid;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidations1 {
	
	@Test
	public void validationSchema()
	{
	Response res=	RestAssured.given()
		.when()
		.get("https://reqres.in/api/users?page=2");
	
	res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("mySchema.json"));
		
		
		
		
		
	}

}

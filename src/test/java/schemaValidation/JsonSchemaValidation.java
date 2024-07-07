package schemaValidation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonSchemaValidation {
	
	@Test
	public void validateListUserSchema()
	{
		RestAssured.given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().log().all();
	}
	
	@Test
	public void validateSchema()
	{
	  Response res= RestAssured.given()
	   .when()
	   .get("https://reqres.in/api/users?page=2");
	  
	  res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("./userSchem.json"));
	}
	
	
	///**********************Authentication***************************
	/***/
	@Test
	public void validateAuthentication()
	{
		RestAssured.given()
		.when()
		.auth().basic("postman", "password")
		.get("https://postman-echo.com/basic-auth")
		.then().log().all();
	}
  
	@Test
	public void digesAuth()
	{
		RestAssured.given()
		.when()
		.auth().digest("postman", "password")
		.get("https://postman-echo.com/digest-auth")
		.then().log().all();
	}
	
	@Test
	public void preemptiveAuth()
	{
		RestAssured.given()
		.auth().preemptive().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then().log().all();
	}
	
	@Test
	public void oauth()
	{
		RestAssured.given()
		.header("Authorization","Bearer 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")
		.when()
		.get("https://api.github.com/user/repos")
		.then().log().all();
	}
	
	
	

}

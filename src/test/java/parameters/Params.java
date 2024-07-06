package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Params {
	/*https://reqres.in/api/users?page=2*/
	
	/**path and query param*/
	
	@Test
	public void understandParam()
	{
	given()
	.pathParam("mypath","api" ) //variable name , value 
	.pathParam("mypath2","users") 
	.queryParam("page","2")                           //page=2
	.when()
	.get("https://reqres.in/{mypath}/{mypath2}")
	.then().log().all();
	}
	
	
	

}

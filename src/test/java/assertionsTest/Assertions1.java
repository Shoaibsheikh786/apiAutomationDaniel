package assertionsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assertions1 {
	
	@Test
	public void getListOfUser()
	{
		Response res=RestAssured.given()
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		String str=res.jsonPath().get("total").toString();
		String tp=res.jsonPath().get("total_pages").toString();
	//	System.out.println(str);
		
		// lindsay.ferguson@reqres.in
		//str ----->
		
		//Assert.assertEquals(str,"munnerferguson@reqres.in");
 //in this api total record we are expecting 12  and total page 2?
		
		Assert.assertEquals(str, "12");
		Assert.assertEquals(tp,"2");
		res.then().statusCode(200);
		
	
	}

}

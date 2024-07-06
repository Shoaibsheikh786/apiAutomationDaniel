package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteReq {
	
	@Test
	public void deleteRec()
	{
		RestAssured.given()
		.when().delete("https://reqres.in/api/users/2")
		.then().statusCode(204);
	}
	
	//1 given() --> contentType , data , cookies, auth, headers 
	//2 when() ---> get() post() put() ....
	//3. then() --> validate , statuscode, reponsebody , cookies , header
	
	//---> Bdd 
	
	//log , bo

}

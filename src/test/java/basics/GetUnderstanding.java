package basics;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUnderstanding {
	
	/* https://reqres.in/api/users/2*/
	
	/*  RESPONSE 
	{
	    "data": {
	        "id": 2,
	        "email": "janet.weaver@reqres.in",
	        "first_name": "Janet",
	        "last_name": "Weaver",
	        "avatar": "https://reqres.in/img/faces/2-image.jpg"
	    },
	    "support": {
	        "url": "https://reqres.in/#support-heading",
	        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
	    }
	}
	*/
	
	// given() when() then();
	
	@Test
	public void understandingGet()
	{    
		RestAssured.given();
		Response res=when()
		 .get("https://reqres.in/api/users/2");
		
		
	//	res.then().log().all();
		
		//classname.______ it will static ;
		res.then().statusCode(201);
		
		// 5 - 10 min
		
		
		//post method ----> data , payload;
		
		
		 
		
		//Response ..
		// Response res ;
		//   int x =5;
		//   String s     ="hello";
		
		
		
		
		//.statusCode(200);
		//.log() --> what we want to see 
		   //--> all()
		   // --> body()
		 
		 //we cans also start from when();
	}
	
	
	

}

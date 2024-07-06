package payloads;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class JsonObjectData {
	
	//1. hashmap
	//2. JsonObject
	
	
/*	
	{
	    "name": "morpheus",
	    "job": "leader"
	}
*/
	
	@Test
     public void josnObjectData()
     {
		
		JSONObject data =new JSONObject();
		data.put("name", "Daniel");
		data.put("Job", "Tester");
	
		
		RestAssured.given().contentType("application/json")
		.body(data.toString())  /* convert data to string */
		.when().post("https://reqres.in/api/users")
		.then().log().all();
     }

}

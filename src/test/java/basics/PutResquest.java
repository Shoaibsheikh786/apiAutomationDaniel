package basics;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PutResquest {
	/*
	 * 
	 {
    "name": "morpheus",
    "job": "leader"
    }
*/
	//1. creating payload with the help of hashmap
	
	HashMap<String,String> data=new HashMap<>();

	
	@Test
	public void postUnder()
	{ 
		    //=
       data.put("name", "abccc");
       data.put("job", "leader");
       
       //given() --> 
       
       // 1.type Of data , 2. data
      Response res= given()
       .contentType("application/json")  //my data is in the form of json
       .body(data)
       .when()
        .put("https://reqres.in/api/users/2");
         res.then().log().body();
         res.then().statusCode(200);
         // when you want to store res dont use then();
         
         
       
       
	}

}

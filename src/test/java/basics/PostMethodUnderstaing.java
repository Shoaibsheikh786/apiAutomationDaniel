package basics;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PostMethodUnderstaing {
	
	/*
	 * 
	 {
    "name": "morpheus",
    "job": "leader"
    }
*/
	
	HashMap<String,String> data=new HashMap<>();

	
	@Test
	public void postUnder()
	{ 
		    //=
       data.put("name", "Muneer");
       data.put("job", "leader");
      
       
       //given() --> 
       
       // 1.type Of data , 2. data
      Response res= given()
       .contentType("application/json")  //my data is in the form of json
       .body(data)
       .when()
        .post("https://reqres.in/api/users");
         res.then().log().headers();
       //  res.then().statusCode(201);
         // when you want to store res dont use then();
         
         //creating paylod , --> 
         //1. HashMap<> --> keys , values, 
       
       
	}

}

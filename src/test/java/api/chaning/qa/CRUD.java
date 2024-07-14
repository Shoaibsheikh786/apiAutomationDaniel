package api.chaning.qa;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CRUD {
	
	
	/**
	 *curl -i -H "Accept:application/json" 
	 *-H "Content-Type:application/json" 
	 *-H "Authorization: Bearer ACCESS-TOKEN" -XPOST 
	 *"https://gorest.co.in/public/v2/users" 
	 *-d '{"name":"Tenali Ramakrishna", 
	 *"gender":"male", "email":"tenali.ramakrishna@15ce.com",
	 * "status":"active"}'*/
	
	HashMap<String,String> data;
	Faker fk;
	String id="7028863";
	String tk="Bearer 2b81030dd63e2d63cdeed5a12bf875e0c67422324b70d2589c974c26622c087c";
	
	
	@BeforeTest
	public void generateData()
	{ 
		fk=new Faker();
		String s;
		s=fk.internet().emailAddress();
		data=new HashMap<>();
		data.put("name","Muneer");
		data.put("gender", "male");
		data.put("email",s);
		data.put("status", "active");
		
	}
	
	
	@Test
	public void createData()
	{
		Response res=given()
		 .contentType("application/json")
		.header("Authorization",tk)
		.body(data)
		.when()
		.post("https://gorest.co.in/public/v2/users");
		
		id=res.jsonPath().get("id").toString();
	//	System.out.println(id);
         res.then().log().body();
         
     System.out.println("#############################################");
		
	
		
	}
	
	//to read the data , i need id of the data 
	
	/**
	 * curl -i -H "Accept:application/json" -H 
	 * "Content-Type:application/json" -H
	 *  "Authorization: Bearer ACCESS-TOKEN" -XPOST 
	 *  "https://gorest.co.in/public/v2/graphql" 
	 *  -d '{"query":"query{user(id: 6940286) 
	 *  { id name email gender status }}"}'
	 * */
	
	
	
  

}

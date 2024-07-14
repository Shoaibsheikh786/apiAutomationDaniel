package api.chaning.qa;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateData {
	
	HashMap<String,String> data;
	Faker fk;
	String id;
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
	public void createData(ITestContext context)
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
		
	   context.setAttribute("Myid",id);
		
	}
}

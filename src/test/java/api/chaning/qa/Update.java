package api.chaning.qa;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Update {
	String id;
	String tk="Bearer 2b81030dd63e2d63cdeed5a12bf875e0c67422324b70d2589c974c26622c087c";
	Faker fk;
	HashMap<String,String> data;
	
	@BeforeTest
	public void generateData()
	{ 
		fk=new Faker();
		String s;
		s=fk.internet().emailAddress();
		data=new HashMap<>();
		data.put("name","Shaoib");
		data.put("gender", "male");
		data.put("email",s);
		data.put("status", "active");
		
	}
	@Test
	public void readData(ITestContext context)
	{
		
		System.out.println("#################################33");
		id=context.getAttribute("Myid").toString();
		
		System.out.println(id);
		given()
		.body(data)
		.contentType("application/json")
		.header("Authorization",tk)
		.pathParam("id",id)
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then().log().body();
	}
	

}

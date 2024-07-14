package api.chaning.qa;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ReadData {
	
	String id;
	String tk="Bearer 2b81030dd63e2d63cdeed5a12bf875e0c67422324b70d2589c974c26622c087c";
	@Test
	public void readData(ITestContext context)
	{
		id=context.getAttribute("Myid").toString();
		
		System.out.println(id);
		given()
		.contentType("application/json")
		.header("Authorization",tk)
		.pathParam("id",id)
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then().log().body();
	}
}

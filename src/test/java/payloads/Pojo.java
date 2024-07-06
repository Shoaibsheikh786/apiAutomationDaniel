package payloads;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*
{
    "name": "morpheus",
    "job": "leader"
}
*/

class User
{
	private String name;  //setter name, getter 
	private String job;   // setter and getter
	
	//setter and getter
	
	public void setName(String n)
	{
		name=n;
	}
	public void setJob(String j)
	{
		job=j;
	}
	
}
public class Pojo {
	
	//3. user plain old java 
	
	@Test 
	public void PojoMethod()
	{
		
	User data=new User();

	
	data.setName("Daniel");
	data.setJob("QA");
	RestAssured.given().contentType("application/json")
	.body(data)
	.when().post("https://reqres.in/api/users")
	.then().log().all();
	}

	
	

}

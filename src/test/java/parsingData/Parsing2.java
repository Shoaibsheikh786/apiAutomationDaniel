package parsingData;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Parsing2 {
	
	
	/* we need to print the record whose id is 8*/
	@Test
	public void findParticularRecord()
	{
		RestAssured.given()
		.when()
		 .get("https://reqres.in/api/users?page=2")
		.then()
		.log().body();
		
		//Fetch all the id  
		
		
	}
	
	//lets print the id's 
	//prinf the record only who is having id number 9

	@Test
	public void findParticularRecord1()
	{
		Response res=RestAssured.given()
		.when()
		 .get("https://reqres.in/api/users?page=2");
		
		JSONObject jo=new JSONObject(res.asString()); 
		
	//	System.out.println(jo);
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		{
		String j1=jo.getJSONArray("data").getJSONObject(i).get("id").toString();
		if(j1.equals("9"))
		{
			JSONObject rec=jo.getJSONArray("data").getJSONObject(i);
			System.out.println(rec);
		}
		
		
		}
		
		
		
	}
	
	//lets print the id's 
	//prinf the record only who is having id number 9
	//does id number 9 have the firstname =Jhon
	
	/**# print the record whose value is greater than 8*/
	@Test
	public void findParticularRecord2()
	{
		String exp="Tobias";
		Response res=RestAssured.given()
		.when()
		 .get("https://reqres.in/api/users?page=2");
		
		JSONObject jo=new JSONObject(res.asString()); 
		
	//	System.out.println(jo);
		boolean b=false;
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		{
		String j1=jo.getJSONArray("data").getJSONObject(i).get("id").toString();
		if(j1.equals("9"))
		{
			String str=jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			if(str.equals(exp))
			{   b=true;
				System.out.println(jo.getJSONArray("data").getJSONObject(i));
				break;
			}
		}
		}
		Assert.assertTrue(b);	
	}
	
	
	

}

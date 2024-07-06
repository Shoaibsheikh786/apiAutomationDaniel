package parsingData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;;

public class Parse {
	
	
	@Test
	public void getRec()
	{
		given()
		.when()
		 .get("https://reqres.in/api/users?page=2")
		.then().log().body();
	}
	
	//first way to verify the response 
	@Test
	public void traverseRecord()
	{  
		int jhonsId=9;
		given()
		.when()
		 .get("https://reqres.in/api/users?page=2")
		.then()
		.body("page",equalTo(2)) //1 assertions
		.body("data[2].id",equalTo(9));
	}
	
	//2nd way to verify the response 
		@Test
		public void traverseRecord2()
		{
			Response res=given()
			.when()
			 .get("https://reqres.in/api/users?page=2");
			
// check is this emaail present or not in the recored "lindsay.ferguson@reqres.in"
			//value;
			
			int count=0;
			String exp="tobias.funke@reqres.in";
			boolean f=false;
			for(int i=0;i<4;i++)
			{
			String s=res.jsonPath().get("data["+i+"].email").toString();
			if(s.equals(exp))
			{
				//code will only be executed if email is found 
				f=true;
				break;	
			}
				
		}
			if(f==true)
			{
				System.out.println("email is present");
				Assert.assertTrue(f);
			}
			else
			{
				System.out.println("email is not preset");
				Assert.assertTrue(f);
			}
			
			
			
			
	// calcalue the sum of all ids ;		
		}
		/** with th help of jsonObject */
		
		//3rd way to verify the response 
				@Test
				public void traverseRecord3()
				{ 
					

							
					Response res=given()
					.when()
					 .get("https://reqres.in/api/users?page=2");
					
					JSONObject jo=new JSONObject(res.asString());
					int sum=0;
					for(int i=0;i<jo.getJSONArray("data").length();i++)
					{
						String s=jo.getJSONArray("data").getJSONObject(i).get("id").toString();
						int a=  Integer.parseInt(s);   
						
						sum =sum +a;
						
						
					}
					// 1000
			    // Assert.assertEquals(sum < 50, true);
				Assert.assertTrue(sum<500);
				
				}

}

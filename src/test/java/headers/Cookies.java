package headers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Cookies {
	
	@Test
	public void getCookie()
	{
		Response res=RestAssured.given()
	    .when().get("https://www.google.com/");
		
	//	res.then().log().cookies();
		
		Map<String, String> ck=res.getCookies();
	//	 System.out.println(ck.get("AEC"));
		 
//		for(String k:ck.keySet())
//		{
//			System.out.println(k +""+ck.get(k));
//		}
		
		Set<String> keys=ck.keySet();
//		
//		System.out.println("keys Size-->"+ck.size());
		
		       
		
//		for(int i=0;i<ck.size();i++)
//		{
//			System.out.println(ck.get("AEC")); 
//		}
//		
		//
		Iterator<String> it=  keys.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
	}

}

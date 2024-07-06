package headers;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Get_Headers {
	
  @Test
  public void getAllHeader()
  {
	 Response res= RestAssured.given().baseUri("https://reqres.in")
	  .when().get("/api/users/2");
	 
	// res.then().log().headers();
//	 String h= res.getHeader("Content-Type");
	// System.out.println(h);
	 
//	 Assert.assertEquals(h,"application/json; charset=utf-8");
	 
	//get all the headers 
	 Headers hd=   res.getHeaders();
//     System.out.println(hd.get("Content-Type"));
     //hd --> header --> keys , and values 
     
     //
	 
      for(Header h:hd)
      {
    	  System.out.println(h.getName() +" "+ h.getValue());
      }
     
     
    
    
	  
	      
	      
  }

}

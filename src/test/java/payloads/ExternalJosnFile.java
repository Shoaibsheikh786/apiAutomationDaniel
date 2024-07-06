package payloads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ExternalJosnFile {
	
	@Test
	public void ExternalJosnReader() throws FileNotFoundException
	{
		//where is my file
		File file=new File("./body.json");
		
		// read that file 
		FileReader fr=new FileReader(file);
		
		//josn tokerner
		JSONTokener jt=new JSONTokener(fr);
		
		
		JSONObject data=new JSONObject(jt);
		
		
		
		
		RestAssured.given()
		.contentType("application/json")
		.body(data.toString())
		.when().post("https://reqres.in/api/users")
		.then().log().all();
	}
	
	

}

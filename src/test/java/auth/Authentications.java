package auth;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Authentications {
	String user;
	String pass;
	String token;    //null
	File file;
	FileInputStream fis;
	Properties pr;
	
	/** basic authentication*/
	@Test
	public void basicAuth()
	{
		RestAssured.given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then().log().all();
	}
	
	/** Digest auth
	 * @throws IOException */
	
	@BeforeTest
	public void getData() throws IOException 
	{
		file=new File("./config.properties");  //cause Error
		fis=new FileInputStream(file);
		pr=new Properties();
		pr.load(fis);
		
	  user= pr.get("username").toString();
	  pass=pr.getProperty("password").toString();
	  token=pr.getProperty("githubToken").toString();
	  
	  System.out.println(user);
	  System.out.println(pass);
	  System.out.println(token);
	
	}
	
	@Test
	public void digestAuth()
	{    
		
		RestAssured.given()
		.auth().digest(user,pass)
		.when()
		.get("https://postman-echo.com/digest-auth")
		.then().body("authenticated",equalTo(true));
	}
	
	@Test
	public void premAuth()
	{
		RestAssured.given()
		.auth().preemptive().basic(user, pass)
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then().log().body();
		
		
	}
	
	/** token value is set by beforeTest()*/
	@Test
	public void Tokenauth()         //no need to generate 
	{
		
		//read the file 
		RestAssured.given()
		.header("Authorization",token)   //null
		.when()
		.get("https://api.github.com/user/repos")
		.then().log().body();
		
		//schema validataion 
		//auth auth, diffent types of auths , read properties files 
		//mulitple ways of executing the test ,
		//generate schema , RESPONSE VALIDATION, 
		
	}
	

	

}

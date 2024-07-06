package assertionsTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class HamcrestAssert {
	
	
	@Test
	public void test1()
	{
		RestAssured.given()
		.baseUri("https://reqres.in")
		.when()
		 .get("/api/users?page=2")
		 .then().log().all();
	}

}

package randomData;

import java.util.Date;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerLib {

  
	@Test
	public void RandomEmail()
	{
		Date date=new Date();
		String s=date.toString().replace(" ","").replace(":", "")+"@gmail.com";
	    System.out.println(s);
	    
	    
	}
	@Test
	public void generateFakerLib()
	{
		Faker fk=new Faker();
		System.out.println(fk.name().fullName()+""+fk.name().lastName()+""+fk.internet().emailAddress()); 

	}
	


}

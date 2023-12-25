package Incorrectdetailsofapplication;

import java.util.Date;

public class Details 
{

	public static String GenerateEmailwithDatetimestamp()
	
	{
		Date date = new Date();
		
		String Timestamp = date.toString().replace(":","_").replace(" ", "_");
		
		return "nikhee" + Timestamp +"@gmail.com";
		
	}
	
	   public static final int IMPLICIT_WAIT = 15;
	   
	   public static final long POST = 20148;
	
	
	
	
	
}

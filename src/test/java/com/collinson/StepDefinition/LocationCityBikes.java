package com.collinson.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;


public class LocationCityBikes {

	String res ="";
	double latitude;
	String Actualcountry="";
	String Actualcity="";
	double longitude;
	float Actuallatitude;
	float Actuallongitude;
	
	
	
	 @Given("^User calls an API with Get request$")
	    public void user_calls_an_api_with_get_request() throws Throwable {
		 
			//System.out.println("I am in");
			
			RestAssured.baseURI ="http://api.citybik.es/v2/networks";
			
			 res=given().log().all()
			.when().get("http://api.citybik.es/v2/networks")
			.then().log().all().statusCode(200).extract().response().asString();
			System.out.println(res);

	    }

	    @Then("^verify city frankfurt is in germany and their latitude and longitude$")
	    public void verify_city_frankfurt_is_in_germany_and_their_latitude_and_longitude() throws Throwable {
	    
		JsonPath js = new JsonPath(res);
		int count = js.getInt("networks.size()");
		
		System.out.println("Print count"+count);
		
		for(int i= 0; i<count;i++)
		{
			Actualcity = js.get("networks["+i+"].location.city");
			if(Actualcity.equalsIgnoreCase("Frankfurt"))
			{
				System.out.println("The value of city ::"+Actualcity);
				Assert.assertEquals(Actualcity,"Frankfurt");
			
			
			 Actualcountry = js.get("networks["+i+"].location.country");
			  if(Actualcountry.equalsIgnoreCase("DE"))
			
					{
						System.out.println("The value of country ::"+Actualcountry);
						Assert.assertEquals(Actualcountry,"DE");
					
					}
			  
			  Actuallatitude = js.get("networks["+i+"].location.latitude");
			  String s=String.valueOf(Actuallatitude);  
			  Assert.assertEquals(s,"50.1072");
			
			  Actuallongitude = js.get("networks["+i+"].location.longitude");
			  String s1=String.valueOf(Actuallongitude); 
			  Assert.assertEquals(s1,"8.66375");
			  
			  System.out.println("The Actuallatitude ::"+Actuallatitude);
			  
			  System.out.println("The Actuallongitude ::"+Actuallongitude);
			  
					}			
		}
		
	    }
	    }
	

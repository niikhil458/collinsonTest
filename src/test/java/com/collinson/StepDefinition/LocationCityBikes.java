package com.collinson.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.junit.Assert.assertEquals;

import org.testng.Assert;

import static io.restassured.RestAssured.*;


public class LocationCityBikes {

	String res ="";
	double latitude;
	double longitude;
	
	@Given("^User calls an API with Get request$")
	public void user_calls_an_API_with_Get_request() {
	
		//System.out.println("I am in");
		
		RestAssured.baseURI ="http://api.citybik.es/v2/networks";
		
		 res=given().log().all()
		.when().get("http://api.citybik.es/v2/networks")
		.then().log().all().statusCode(200).extract().response().asString();
		//System.out.println(res);

	}
	
	@Then("^verify city frankfurt is in germanay$")
	public void verify_city_frankfurt_is_in_germanay() {
		
		
		JsonPath js = new JsonPath(res);
		int count = js.getInt("networks.size()");
		
		System.out.println("Print count"+count);
		
		
		
		
		//city
		String cityName = js.get("networks[384].location.city");
		System.out.println("cityname ::"+cityName);
		
		
		//country
			 String Actualcountry = js.get("networks[384].location.country");
				System.out.println("countryName ::"+Actualcountry);
		Assert.assertEquals(Actualcountry,"DE");
	 
	}
	
	
	@Then("^verify latitude and longitude$")
	public void verify_latitude_and_longitude() {

		JsonPath js = new JsonPath(res);
		int count = js.getInt("networks.size()");

		System.out.println("Print count" + count);

		//lattitude
		
		latitude = js.getDouble("networks[384].location.latitude");
		System.out.println("lattitude ::" + latitude);

		// longitude

		longitude = js.getDouble("networks[384].location.longitude");
		System.out.println("lattitude ::" + longitude);
		
		
		/*Assert.assertEquals(latitude,"50.1072");
		Assert.assertEquals(longitude,"8.66375");*/
	
	}

	
	@Then("^Verify city frankfurt id$")
	public void verify_city_frankfurt_id() {

		JsonPath js = new JsonPath(res);
		int count = js.getInt("networks.size()");

		//System.out.println("Print count" + count);
		
		// ID NAME
				String idName = js.get("networks[384].id");
				System.out.println("Id Name"+idName);
				
				Assert.assertEquals(idName, "visa-frankfurt");
		
	
	}
	
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		
		
	}
	
	
}

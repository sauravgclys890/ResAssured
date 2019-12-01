package com.aapitesting.TestAPI;

import org.openqa.selenium.lift.Matchers;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class TestWheatherAPI {
	
	@Test
	public void getWheatherInfo() {
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
		 ValidatableResponse response=RestAssured.given().param("q", "Delhi").param("appid", "17e5c69afcef0f16365a6c3b0cba4400")
		.when().get().then();
		 
		 Reporter.log("Response is= "+response.extract().asString(), true);
		 
		 
		 int statuscode=response.extract().statusCode();
		 SoftAssert softAssertion= new SoftAssert();
		 softAssertion.assertEquals(statuscode, 200);
		 Reporter.log("Verified the status code successfully", true);
		 
		 String contentType= response.extract().contentType();
		 Reporter.log("Contect Type is = "+contentType, true);
		 softAssertion.assertEquals(contentType, "application/json; charset=utf-8");
		 Reporter.log("Content type verified", true);
		 
		 String countryCode= response.extract().response().path("sys.country");
		 softAssertion.assertEquals(countryCode, "IN");
		 Reporter.log("Country code verifed successfully", true);
		 
		 String countryName= response.extract().response().path("name");
		 softAssertion.assertEquals(countryName, "Delhi");
		 Reporter.log("Country code verifed successfully", true);
		 
		 softAssertion.assertAll();
		
		
	}
	
	@Test(priority=1)
	public void getWheatherInfoOfBangaloreWithValidData() {
		
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
		String response=RestAssured.given().param("q", "Bangalore").param("appid", "17e5c69afcef0f16365a6c3b0cba4400")
		.when().get().then().extract().asString();
		
		System.out.println("Response is :- " + response);

		Reporter.log("Response is: " + response, true);
		
		ValidatableResponse res=RestAssured.given().param("q", "Bangalore").param("appid", "17e5c69afcef0f16365a6c3b0cba4400")
		.when().get().then();
		
	    res.statusCode(200);
	    Reporter.log("Verified Success code Successfully", true);
	    
	    res.contentType(ContentType.JSON);
	    
	    String countryName=res.extract().response().path("sys.country");
	    Reporter.log("Country name is verified= "+countryName, true);
	    
	    JsonPath path= new JsonPath(response);
	    System.out.println("Country Name= "+path.get("sys.country"));
	    
	   
	    
	}
	
	@Test
	public void getWheatherInfoBangaloreWithInvalidData() {
		
		 ValidatableResponse res=RestAssured.given().param("q", "Bangaloree")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then();
		 
		 Reporter.log("Response for invalid data= "+ res.extract().asString(), true);
		 
		 res.statusCode(404);
		 Reporter.log("Status code is verified for Invalida data", true);
		 
		 int status= res.extract().statusCode();
		 Assert.assertEquals(status, 404);
		 Reporter.log("Status code is verified with invalid data", true);
		 
		 res.contentType(ContentType.JSON);
		 Reporter.log("Content is verifed ", true);
		 
	}

}

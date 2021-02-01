package com.api_with_testng;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.cli.Main;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ManualToAutomationWithTestng {

	Response responce;

	@BeforeTest
	public void setup() {
		responce = RestAssured.get(" http://dummy.restapiexample.com/api/v1/employees");
	}

	@Test
	public void dataCheck() {
//boolean responceData = responce.toString() != null;
		Assert.assertTrue(responce.toString() != null);// true
	}

	@Test(dependsOnMethods = { "dataCheck" })
	public void statusValue() {

		JsonPath jp = responce.jsonPath();
		Assert.assertEquals(jp.get("status").toString(), "success");
		System.out.println(jp.get("status").toString());

	}

	@Test(dependsOnMethods = { "statusValue" })
	public void dataFormat() {

		System.out.println(responce.contentType().contains("json"));// true

		Assert.assertTrue(responce.contentType().contains("json"));
	}

	@Test(dependsOnMethods = { "dataFormat" })
	public void statusCode() {

		System.out.println(responce.statusCode());
		Assert.assertEquals(responce.statusCode(), 200);
		//Assert.assertTrue(responce.statusCode() == 200);

	}
}

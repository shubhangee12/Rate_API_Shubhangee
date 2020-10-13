package com.companyname.projectname.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class StepDef {

    private final static Logger logger = Logger.getLogger(StepDef.class.getName());
    public static String url;
    public static String STATUS_CODE;
    public static Response response;
    public static String requestType;
    public static String REQUESTBODY;
    public static String RESPONSEBODY;
    @Given("User is hitting the API {string} with Method {string}")
    public void userIsHittingTheAPIWithMethod(String Endpoint, String Method) {
       url= Endpoint;
        requestType=Method;
    }

    @Then("Verify Status code should be {string}")
    public void verifyStatusCodeShouldBe(String RCode) {

        RestAssured.baseURI=url;
        response = RestAssured.get(url);
            STATUS_CODE = String.valueOf(response.getStatusCode());
            Assert.assertEquals(STATUS_CODE, RCode);
            RESPONSEBODY = response.getBody().asString();



    }

    @Then("Verify Response body should have {string} with Value {string}")
    public void verifyResponseBodyShouldHaveWithValue(String param, String value)throws Throwable {
        Object obj = param;
        JSONParser parser = new JSONParser();
        JSONObject responseObject = (JSONObject) parser.parse(RESPONSEBODY);
        Object key = (Object) responseObject.get(param);
        compareResponseValues(String.valueOf(value), String.valueOf(key), param);


    }

    private void compareResponseValues(String expected, String actual, String responseKey) {

        logger.info("Actual Value is  ::" + actual);
        logger.info("Expected Value is  ::" + expected);
        if (expected.equals(actual)) {
            Assert.assertEquals(actual, expected);
            System.out.println("given Value Exist in Response Body");
        } else {
            System.out.println("given Value does not Exist in Response Body");
            Assert.assertEquals(actual, expected);
        }
    }
    @When("query Param {string} with Value {string}")
    public String queryParamWithValue(String Qparam, String QValue) {
        url= url + "?"+Qparam+"="  +QValue;
        System.out.println(url);
        return url;
    }

    @Then("verify date in response should be {string}")
    public void verifyDateInResponseShouldBe(String pdate) throws Throwable{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        String param1="date";
        String strDate= formatter.format(date1);
        System.out.println(strDate);
        JSONParser parser = new JSONParser();
        JSONObject responseObject = (JSONObject) parser.parse(RESPONSEBODY);
        Object key = (Object) responseObject.get(param1);
        System.out.println(String.valueOf(key));
        int var1= pdate.compareTo(strDate);
        if (var1 > 1) {
            compareResponseValues(String.valueOf(key), String.valueOf(pdate), pdate);
            System.out.println("Future Date");
        }else if (var1 == 0)
        {
            compareResponseValues(String.valueOf(key), String.valueOf(pdate), pdate);
            System.out.println("past date Date");
        }
        else
        {

            compareResponseValues(String.valueOf(key), String.valueOf(pdate), pdate);
            System.out.println("past date Date");

        }



    }
}


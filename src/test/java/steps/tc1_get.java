package steps;

import static org.junit.Assert.assertEquals;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utilities.ReportGenerator;

public class tc1_get extends ReportGenerator {

private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
Response response;
RequestSpecification request;
ResponseBody body;
@Given("the user has the  REST API endpoint")
public void the_user_has_the_REST_API_endpoint() {
startTest();
System.out.println("Home Page");
   RestAssured.baseURI=BASE_URL;
   request = RestAssured.given();
}

@When("I send a GET request to the endpoint is {string}")
public void i_send_a_GET_request_to_the_endpoint_is(String string) {
response = request.get(string);
}

@Then("the response status code will be {int}")
public void the_response_status_code_will_be(Integer int1) {
int statusCode = response.getStatusCode();
     int expStatusCode=int1;
    assert response.getStatusCode() == int1 : "Expected status code " + int1 + " but got " + response.getStatusCode();
}

@Then("the response content type should be as {string}")
public void the_response_content_type_should_be_as(String string) {
System.out.println("The Details are : ");
 String  output=response.asString();
  System.out.println(output);
  endTest();
}



}
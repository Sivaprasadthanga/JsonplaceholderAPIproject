package steps;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utilities.ReportGenerator;

public class tc3put extends ReportGenerator {
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/1";
	Response response;
	RequestSpecification request;
	String output;
	ResponseBody body;

	@Given("the user in the HOME page for put data")
	public void the_user_in_the_HOME_page_for_put_data() {
		startTest();
		System.out.println("user in the home page");
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given();

	}

	@When("he puts the data")
	public void he_puts_the_data() {
		System.out.println("puts data");
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", 1);
		requestParams.put("id", 1);
		requestParams.put("title", "test");
		requestParams.put("body", "user access");
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		response = request.put();
		body = response.body();
	}

	@Then("the system returns the status code as {int}")
	public void the_system_returns_the_status_code_as(Integer int1) {
		System.out.println("Validates status code");
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
        assert response.getStatusCode() == int1 : "Expected status code " + int1 + " but got " + response.getStatusCode();
        endTest();
        endReport();
        
	}

}

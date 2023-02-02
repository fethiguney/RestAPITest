package stepDefinitons;

import baseUrl.RegresBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.GetUserDataPojo;
import pojos.GetUserPojo;
import pojos.GetUserSupportPojo;

import static baseUrl.RegresBaseUrl.spec;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    Response response;
    GetUserDataPojo getUserDataPojo;
    GetUserSupportPojo getUserSupportPojo;
    GetUserPojo expectedData;
    GetUserPojo actualData;
    @Given("set the url to get a single user")
    public void set_the_url_to_get_a_single_user() {
        spec.pathParams("first", "users", "second", 2);
    }
    @Given("set the expected data with to get a single user")
    public void set_the_expected_data_with_to_get_a_single_user() {
        getUserDataPojo=new GetUserDataPojo(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        getUserSupportPojo=new GetUserSupportPojo("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
        expectedData=new GetUserPojo(getUserDataPojo, getUserSupportPojo);
        System.out.println("expected data " + expectedData);
    }
    @When("send a request to get a single user and get response")
    public void send_a_request_to_get_a_single_user_and_get_response() {
        response=given().spec(spec).when().get("/{first}/{second}");

    }
    @Then("assert that status code {int}")
    public void assert_that_status_code(int successStatusCode) {
        response.then().statusCode(successStatusCode);
    }
    @Then("assert that expected data equals to actual data")
    public void assert_that_expected_data_equals_to_actual_data() {
        actualData=response.as(GetUserPojo.class);
        System.out.println("actualdata : " +actualData);

        assertEquals(expectedData.getData().getId(), actualData.getData().getId());
        assertEquals(expectedData.getData().getFirst_name(), actualData.getData().getFirst_name());
        assertEquals(expectedData.getData().getLast_name(), actualData.getData().getLast_name());
        assertEquals(expectedData.getData().getAvatar(), actualData.getData().getAvatar());
        assertEquals(expectedData.getSupport().getText(), actualData.getSupport().getText());
        assertEquals(expectedData.getSupport().getUrl(), actualData.getSupport().getUrl());


    }
}

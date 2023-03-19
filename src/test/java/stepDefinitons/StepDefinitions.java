package stepDefinitons;

import io.cucumber.java.en.*;

import static baseUrl.RestfulBaseUrl.spec;

public class StepDefinitions {


    @Given("set the url to get a single user")
    public void set_the_url_to_get_a_single_user() {
        spec.pathParams("first", "");
    }
    @Given("set the expected data with to get a single user")
    public void set_the_expected_data_with_to_get_a_single_user() {

    }
    @When("send a request to get a single user and get response")
    public void send_a_request_to_get_a_single_user_and_get_response() {


    }
    @Then("assert that status code {int}")
    public void assert_that_status_code(int successStatusCode) {

    }
    @Then("assert that expected data equals to actual data")
    public void assert_that_expected_data_equals_to_actual_data() {



    }
}

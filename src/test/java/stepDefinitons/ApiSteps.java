package stepDefinitons;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static baseUrl.RestfulBookerBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class ApiSteps {

    Response response;

    @Given("user sends a get request for specific booking")
    public void user_sends_a_get_request_for_specific_booking() {
        spec.pathParams("first", "booking", "second", 1);
        response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
    }
    @Given("user gets the booking data and validates")
    public void user_gets_the_booking_data_and_validates() {
        response.then().assertThat().statusCode(200);
    }

}

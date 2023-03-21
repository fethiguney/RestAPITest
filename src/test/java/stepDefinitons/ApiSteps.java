package stepDefinitons;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.BookingDates;
import pojos.Booking;
import pojos.BookingResponseBody;

import static baseUrl.RestfulBookerBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.junit.Assert.assertEquals;

public class ApiSteps {

    Booking expectedData;
    Response postResponse;

    @Given("user set the expected data")
    public void user_set_the_expected_data() {
        BookingDates bookingDatesPojo=new BookingDates("2021-09-21", "2021-12-21");
        expectedData=new Booking("Ali",
                "Can", 999, true,
                bookingDatesPojo, "Breakfast");
        System.out.println("expected : "+expectedData);
    }
    @When("user sends a post request to to create a new booking")
    public void user_sends_a_post_request_to_to_create_a_new_booking() {
        spec.pathParam("first", "booking");
        postResponse=given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");



    }
   /* @Given("user sends a get request for specific booking")
    public void user_sends_a_get_request_for_specific_booking() {
        spec.pathParams("first", "booking", "second", 1);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
    }*/
    @Given("user gets the booking data and validates")
    public void user_gets_the_booking_data_and_validates() {
        BookingResponseBody actualData=postResponse.as(BookingResponseBody.class);
        System.out.println("actual :"+actualData);

        postResponse.then().assertThat().statusCode(200);
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

    }

}

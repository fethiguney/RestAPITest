package stepDefinitons;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.BookingDates;
import pojos.Booking;
import pojos.BookingResponseBody;

import static baseUrl.RestfulBookerBaseUrl.spec;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class ApiSteps {

    Booking expectedData;
    Response postResponse;
    Response getResponse;
    static Integer bookingId;


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

    @Given("user gets the booking data and validates")
    public void user_gets_the_booking_data_and_validates() {
        BookingResponseBody actualData=postResponse.as(BookingResponseBody.class);
        System.out.println("actual :"+actualData);

        bookingId=actualData.getBookingid();

        postResponse.then().assertThat().statusCode(200);
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

    }
    @Given("user sends a get request for created booking")
    public void user_sends_a_get_request_for_created_booking() {
        spec.pathParams("first", "booking", "second", bookingId);

        getResponse=given().spec(spec).when().get("/{first}/{second}");
    }
    @Then("user gets the booking id data and validates")
    public void user_gets_the_booking_id_data_and_validates() {
       Booking getActualData=getResponse.as(Booking.class);
        System.out.println(getActualData);

        assertEquals(200, getResponse.statusCode());
        assertEquals(expectedData.getFirstname(), getActualData.getFirstname());
        assertEquals(expectedData.getLastname(), getActualData.getLastname());
        assertEquals(expectedData.getTotalprice(), getActualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), getActualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),getActualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), getActualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), getActualData.getAdditionalneeds());
    }

}

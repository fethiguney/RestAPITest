package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBaseUrl {
    public static RequestSpecification spec;

    @Before
    public static void restfulSetup(){

        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/booking").build();
    }
}

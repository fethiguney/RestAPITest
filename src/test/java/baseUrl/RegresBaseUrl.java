package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RegresBaseUrl {
    public static RequestSpecification spec;

    @Before
    public static void reqresSetup(){

        spec = new RequestSpecBuilder().setBaseUri("https://reqres.in/api/").build();
    }
}

package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestfulBookerBaseUrl {

    public static RequestSpecification spec;

    public static void restfulSetUp(){
        spec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }


}

package stepDefinitons;

import io.cucumber.java.Before;

import static baseUrl.RestfulBookerBaseUrl.restfulSetUp;

public class Hooks {

    @Before
    public void beforeApi() {
        restfulSetUp();
    }


}

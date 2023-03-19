package stepDefinitons;

import io.cucumber.java.Before;

import static baseUrl.RestfulBaseUrl.restfulSetup;

public class Hooks {
    @Before(value ="@apitest" )
    public void beforeApi() {
        restfulSetup();
    }
}

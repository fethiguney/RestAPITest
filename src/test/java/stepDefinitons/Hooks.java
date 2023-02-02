package stepDefinitons;

import io.cucumber.java.Before;

import static baseUrl.RegresBaseUrl.reqresSetup;

public class Hooks {
    @Before(value ="@apitest" )
    public void beforeApi() {
        reqresSetup();
    }
}


  Feature: Restful booker API test

    @getrequest
    Scenario: Get a specific booking based upon the booking id provided
        Given user sends a get request for specific booking
        And user gets the booking data and validates
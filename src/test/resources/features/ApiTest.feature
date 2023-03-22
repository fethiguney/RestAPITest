
  @apitest
  Feature: Restful booker API test

    @postRequest
    Scenario: Create a new booking in the API
      Given user set the expected data
      When user sends a post request to to create a new booking
      Then user gets the booking data and validates

    @getRequest
    Scenario:Get the new created booking id informations
      Given user set the expected data
      When user sends a get request for created booking
      Then user gets the booking id data and validates

    @putRequest
    Scenario:Update the current booking
      Given user set the expected data and update all data
      When user sends a put request to new created booking to update all data
      Then user gets the put request response and validates






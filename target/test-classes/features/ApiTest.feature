
  @apitest
  Feature: Restful booker API test

    @postRequest
    Scenario: Create a new booking in the API
      Given user set the expected data
      When user sends a post request to to create a new booking
      And user gets the booking data and validates

    @getRequest
    Scenario:Get the created booking id informations
      Given user set the expected data
      Given user sends a get request for created booking
      And user gets the booking id data and validates





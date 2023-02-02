
  Feature: Reqres API test

    @apitest
    Scenario: Get a single user informations and do assertion
      Given set the url to get a single user
      And set the expected data with to get a single user
      When send a request to get a single user and get response
      Then assert that status code 200
      And  assert that expected data equals to actual data


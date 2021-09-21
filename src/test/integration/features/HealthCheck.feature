Feature: Employee dashboard api (Integration Tests)

     @Dev  
  Scenario Outline: Validate Health Check of Employee dashboard api
    When I make a request for health check to Employee dashboard api
    Then I should get the response with StatusCode as <StatusCode> and health check message as <healthcheckmessage>
    Examples:
      | User               | StatusCode | healthcheckmessage    |
      | HasimValidUser     | 200        | Employee dashboard api is up |

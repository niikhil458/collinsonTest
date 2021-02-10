Feature: Validating Exact Location of city bikes

  @Regression
  Scenario: Verify city frankfurt is in germany and return their corresponding latitude and longitude
    Given User calls an API with Get request
    Then verify city frankfurt is in germany and their latitude and longitude

Feature: Validating Exact Location of city bikes
 

  
  Scenario: Verify city frankfurt is in germany and return their corresponding latitude and longitude
    Given User calls an API with Get request
    Then verify city frankfurt is in germanay
    Then verify latitude and longitude
   
    

  
  Scenario: Verify city frankfurt ID
    Given User calls an API with Get request
    Then Verify city frankfurt id
    
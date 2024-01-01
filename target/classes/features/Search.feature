Feature: Search functionality

  Scenario: User search for a valid product
    Given User open the application
    When User enters valid product "HP" into search box field
    And User click on search button
    Then User should get valid product displayed in search results
    
   Scenario: User search for a valid product
    Given User open the application
    When User enters invalid product "Honda" into search box field
    And User click on search button
    Then User should get a message about no products matching
    
   Scenario: User search without any product
    Given User open the application
    When User do not enters any products into search box field
    And User click on search button
    Then User should get a message about no products matching

Feature: Login Functionality

  Scenario Outline: Login with valid credentials
    Given User has navigated to login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User click on Login button
    Then User should get succesfully logged in

    Examples: 
      | username               | password |
      | amotooricap1@gmail.com |    12345 |
      | amotooricap2@gmail.com |    12345 |
      | amotooricap3@gmail.com |    12345 |

  Scenario: Login with invalid credentials
    Given User has navigated to login page
    When User enters invalid email address "test@gmail.com" into email field
    And User enters invalid password "123" into password field
    And User click on Login button
    Then User should get proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User has navigated to login page
    When User enters valid email address "testdemo@gmail.com" into email field
    And User enters valid password "123" into password field
    And User click on Login button
    Then User should get proper warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
    Given User has navigated to login page
    When User enters valid email address "test@gmail.com" into email field
    And User enters valid password "123456" into password field
    And User click on Login button
    Then User should get proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User has navigated to login page
    When User do not enter email address into email field
    And User do not enter password into password field
    And User click on Login button
    Then User should get proper warning message about credentials mismatch

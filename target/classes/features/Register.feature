Feature: Register functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register account page
    When User enters the details into below fields
      | firstName | Test      |
      | lastName  | Demo      |
      | telephone | 012345678 |
      | password  |     12345 |
    And User selects privacy and policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Register account page
    When User enters the details into below fields
      | firstName | Test      |
      | lastName  | Demo      |
      | telephone | 012345678 |
      | password  |     12345 |
    And User selects Yes for Newsletter
    And User selects privacy and policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register account page
    When User enters the details into below fields with duplicate email
      | firstName | Test               |
      | lastName  | Demo               |
      | email     | testdemo@gmail.com |
      | telephone |          123456789 |
      | password  |             123456 |
    And User selects Yes for Newsletter
    And User selects privacy and policy
    And User clicks on continue button
    Then User should get proper warning message about duplicate email

  Scenario: User creates an account without filling any details
    Given User navigates to Register account page
    When User do not enter any details into fields
    And User clicks on continue button
    Then User should get proper warning message for every mandatory field

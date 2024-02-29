Feature: SmartPhone pages assertions

Feature: SmartPhone pages assertions
  @smartPhonePrice
  Scenario: User checks the total price for smartPhones page
    Given user lands on Inar Academy home page
    When user clicks on Target Market button
    And user enter name to nameBox
    And user enter password to passwordBox
    And user clicks on login button
    And user clicks on smartPhones button
    And create connection with database
    And execute query for total price for smartPhones
    And user checks the total price of smartPhones
    And destroy the connection
    Then user close window


  @smartPhoneDiscount
  Scenario: User checks the total discount in smartPhones page
    Given user lands on Inar Academy home page
    When user clicks on Target Market button
    And user enter name to nameBox
    And user enter password to passwordBox
    And user clicks on login button
    And user clicks on smartPhones button
    And create connection with database
    And execute query for total discount amount of smartPhones
    And user checks total discount amount of smartPhones
    And destroy the connection
    Then user close window
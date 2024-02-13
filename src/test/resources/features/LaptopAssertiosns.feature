Feature: Laptop pages assertions
   @1
  Scenario: User checks the total price for laptops page
    Given user lands on Inar Academy home page
    When user clicks on Target Market button
    And user enter name to nameBox
    And user enter password to passwordBox
    And user clicks on login button
    And user clicks on laptops button
    And create connection with database
    And execute query for total price for laptops
     And user checks the total price of laptops
     And destroy the connection
    Then user close window



   @2
  Scenario: User checks the total discount in laptops page
    Given user lands on Inar Academy home page
    When user clicks on Target Market button
    And user enter name to nameBox
    And user enter password to passwordBox
    And user clicks on login button
    And user clicks on laptops button
    And create connection with database
    And execute query for total discount amount of laptops
     And user checks total discount amount of laptops
     And destroy the connection
    Then user close window
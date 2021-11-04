Feature: User_Management

  Scenario: Add a user and validate the user has been added to the table
    Given user is on User_Page "https://www.way2automation.com/angularjs-protractor/webtables/"
    When user enters <firstname>,<lastname>,<username>,<password>,<Email>,<cellphone>
    When user clicks on save button 
    Then a user is added
    And I add a user to web table
    Then delete a user from the web table

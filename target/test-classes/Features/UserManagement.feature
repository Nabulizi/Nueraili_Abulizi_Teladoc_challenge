Feature: User_Management

  Scenario: Add a user and validate the user has been added to the table
    Given user is on User_Page "https://www.way2automation.com/angularjs-protractor/webtables/"
    When user click add_user link 
    Then user should see add_user modal
    When user enters "Nueraili" in firstname field
    And user enters "Nabulizi" in username field 
    And user enters "1234" in password field
    And user enters "1234567" in cellphone field
    And user selects "Admin" role 
    And user clicks on save button 
    Then user "Nueraili" is added

    


      
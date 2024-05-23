Feature: User login
  Scenario: Successfull login
    Given the user enter opencart application
    And enter the valid credential(Username:"sarumathi.natarajan@gmail.com",password:"Test@123")
    When user click the login button
    Then  it navigate to my account page
    And user see the user name in my account page
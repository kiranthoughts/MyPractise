Feature: Login Unsuccessful

  user is not able to login with invalid credentials
  @loginTest
  Scenario:

    Given User enters url "http://www.next.co.uk"
    When user enters My Account link in the header
    And user enters invalid Email-Id "Florina-paul@gmail.com"
    And user enters invalid Password "abc123"
    And user clicks SignIn button
    Then user sees a login unsuccessful message "Please check your sign in details are correct and try again."

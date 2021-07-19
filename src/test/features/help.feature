Feature: Contact details for help
    as a user I want to see Contact details to get help
  @helpTest
  Scenario:

    Given User is on home page "http://next.co.uk"
    When user clicks on the help link in header
    And user clicks on Contact Us link
    Then user gets the contact list numbers
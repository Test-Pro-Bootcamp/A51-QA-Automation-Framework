Feature: Login

  Scenario: Page url not changed when Log in button clicked with empty credential fields
    Given User is on login page
    When I click on 'Log in'
    Then page url was not changed
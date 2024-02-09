Feature: Login feature
  Scenario: Login Success
    Given I open Login Page
    And I open Login Page
    When I enter email "zhanna.ivanova@testpro.io"
    And I enter password "12345678"
    And I submit
    Then I should get logged in




Feature:Login feature

  Scenario:Login Success
    Given I open Login Page
    And I enter email "aparajita.jha@testpro.io"
    And I enter password"testpro135@"
    And I submit
    Then I should get logged in
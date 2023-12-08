Feature: Login feature

# Use a hashtag to enter comments in Cucumber

  Scenario: Login Success
  Given I open Login page
  When I enter email "adam.johnson@testpro.io"
  And I enter password "1Te$t$tudent"
  And I click submit
  Then I should be logged in


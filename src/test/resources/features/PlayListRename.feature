Feature: Rename the play list

  Scenario: Rename the playlist is successful
    Given I open login page
    When I open Home Page
    And I double click on the play list
    And I enter new play list name
    Then The play list is renamed




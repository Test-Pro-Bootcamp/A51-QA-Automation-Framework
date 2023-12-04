Feature: Play song with click button

  Scenario: play song success
    Given I open Home Page
    When I choose All songs list
    And I choose first song
    And I click play button
    Then The song is playing

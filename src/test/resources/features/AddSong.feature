Feature: Add song to playlist
  Scenario: Add song to playlist successful
    Given I open login page
    When I open Home Page
    And I search the song "birthday"
    And I click view all button
    And I choose the song
    And I add this song in the play list
    And I choose the play list
    Then I see the notification Message about adding the song
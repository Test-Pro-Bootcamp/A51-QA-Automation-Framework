Feature: Login feature

  #hier is comments
  Scenario: Login Success
    Given I open Login Page
    When I enter email "daria.chebotnyagina@testpro.io"
    And I enter password "Asdfasdf1"
    And I submit
    Then I should get logged in

  Scenario Outline: Login Incorrect Password
    Given I open Login Page
    When I enter email "<email>"
    And I enter password "<password>"
    And I submit
    Then I should get logged in

    Examples:
      |email                          |password|
      |incorrect@gmail.com            |Asdfasdf1|
      |daria.chebot@gmail.com         |Asdfasdf1|
      |daria.chebotnyagina@testpro.io |Asdfasdf1|
      |daria.chebotnyagina@gmail.com  |         |

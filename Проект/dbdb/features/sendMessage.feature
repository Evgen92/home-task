Feature: Test send massage in mail.ru

Scenario: Test send message to users
    Given I am in home page
    When I click to write message
    When I change subject
    When I write message
    Then I see message to deliver my message
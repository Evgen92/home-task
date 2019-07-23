Feature: Test login in mail.ru

Scenario: Test get access to mail
    Given I am on main Mailru page
    When I enter login "truhanzhenya" and password "truhan"
    Then I see home page

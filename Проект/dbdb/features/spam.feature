Feature: Test spam in mail.ru

  Scenario: Test add mail to spam
    Given I am in home page
    When I add mail to spam
    Then I see message send to spam

  Scenario: Test return mail from spam
    Given I am in home page
    When I return mail from spam
    Then I see message return from spam

  Scenario: Test sort author mail letters
    Given I am in home page
    When  I click button sort Author
    Then I see sorting author list desc

  Scenario: Test sort date mail letters
    Given I am in home page
    When I click button sort Date asc
    Then I see sorting date list asc

  Scenario: Test sort date mail letters
    Given I am in home page
    When I click button sort Date desc
    Then I see sorting date list desc
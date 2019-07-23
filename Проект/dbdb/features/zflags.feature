Feature: Test add and uncheck flags in mail.ru

  Scenario: Test add flags to mail
    Given I am in home page
    When I add 3 flags
    Then I see 3 marked mails

  Scenario: Test remove flags from mails
    Given I am in home page
    When I remove 3 flags
    Then I see 0 marked mails

  Scenario: Test delete letter
    Given I am in home page
    When I add letter to basket
    Then I see message delete letter

  Scenario: Test return letter from basket
    Given I am in home page
    When I return letter from basket
    Then I see message return from basket

  Scenario: Test add letter to archive
    Given I am in home page
    When I add letter to archive
    Then I see message moved letter to archive

  Scenario: Test return mail from basket
    Given I am in home page
    When I return letter from archive
    Then I see message return letter from archive
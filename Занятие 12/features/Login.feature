Feature: Test login page

  Scenario: Test positive first login page
    Given I am on main application page
    When I login as correct user
    Then I see logout link

  Scenario: Test positive two login page
    Given I am on main application page
    When I login as correct user
    When I am on home page
    Then I see logout link

  Scenario: Test positive three login page
    Given I am on main application page
    When I login as correct user
    When I am on spam page
    Then I see logout link

  Scenario: Test positive four login page
    Given I am on main application page
    When I login as correct user
    When I am on write letter page
    Then I see logout link

  Scenario: Test positive five login page
    Given I am on main application page
    When I login as correct user
    When I am on all letters page
    Then I see logout link

  Scenario: Test positive six login page
    Given I am on main application page
    When I login as correct user
    When I am on mark letters page
    Then I see logout link


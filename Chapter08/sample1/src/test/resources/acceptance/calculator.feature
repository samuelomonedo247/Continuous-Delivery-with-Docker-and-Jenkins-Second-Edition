Feature: Calculator
  Scenario: Div two numbers
    Given I have two numbers: 6 and 3
    When the calculator divs them
    Then I receive 3 as a result

Feature: Ingredient Stock Tracking

  As a kitchen manager,
  I want to track ingredient stock levels in real time
  So that I can prevent shortages and ensure continuous operations

  As a system,
  I want to automatically suggest restocking when ingredients are low
  So that kitchen managers can take action promptly

  Scenario Outline: Track stock level and decide restocking
    Given the system has an ingredient "<Name>" with quantity <Quantity> and restock threshold <Threshold>
    When the kitchen manager checks the ingredient stock for "<Name>"
    Then the system should display the current quantity as <Quantity>
    And the system should <Suggestion> restocking for "<Name>"

    Examples:
      | Name   | Quantity | Threshold | Suggestion    |
      | Rice   | 5        | 10        | suggest       |
      | Sugar  | 20       | 15        | not suggest   |
      | Salt   | 2        | 5         | suggest       |
      | Milk   | 12       | 10        | not suggest   |

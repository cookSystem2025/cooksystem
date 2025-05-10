Feature: Ingredient Stock Tracking

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

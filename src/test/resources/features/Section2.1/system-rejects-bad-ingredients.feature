Feature: Validate ingredient combinations

  Scenario Outline: System blocks invalid selections
    Given these ingredients are available:
      | Ingredient |
      | <Available1> |
      | <Available2> |
    When the customer selects "<Select1>" and "<Select2>"
    Then the system should show a warning: "<WarningMessage>"

    Examples:
      | Available1 | Available2 | Select1 | Select2 | WarningMessage                |
      | Chicken    | Rice       | Chicken | Nuts    | Nuts are not available        |
      | Fish       | Cheese     | Fish    | Cheese  | Fish and cheese don’t mix     |

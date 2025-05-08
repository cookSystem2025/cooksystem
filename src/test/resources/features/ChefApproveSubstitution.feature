Feature: Chef approves or rejects ingredient substitutions

  As a chef,
  I want to be alerted when a substitution is suggested
  so that I can approve or adjust the final recipe.

  Scenario Outline: Chef reviews a suggested substitution
    Given the system suggests replacing "<OriginalIngredient>" with "<AlternativeIngredient>"
    When the chef receives the substitution alert
    Then the chef can approve or reject the suggested substitution

    Examples:
      | OriginalIngredient | AlternativeIngredient |
      | Chicken             | Turkey                |
      | Beef                | Mushroom              |
      | Milk                | Almond Milk           |
      | Cheese              | Vegan Cheese          |
      | Pasta               | Quinoa                |

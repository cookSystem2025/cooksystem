Feature: Chef approves or rejects ingredient substitutions

  Scenario Outline: Chef reviews a suggested substitution
    Given the system suggests replacing "<OriginalIngredient>" with "<AlternativeIngredient>"
    When the chef receives the substitution alert
    Then the chef can approve or reject the suggested substitution

    Examples:
      | OriginalIngredient | AlternativeIngredient |
      | Chicken            | Turkey                |
      | Beef               | Beans                 |
      | Milk               | Soy Milk              |
      | Cheese             | Plant Cheese          |
      | Pasta              | Rice                  |


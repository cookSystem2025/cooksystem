Feature: Suggest alternative ingredients when an item is unavailable or restricted

  Scenario Outline: System suggests an alternative ingredient
    Given the system has these ingredients:
      | Ingredient | Available | SuitableForDiet |
      | <Item1>    | <Av1>     | <Diet1>         |
      | <Item2>    | <Av2>     | <Diet2>         |
      | <Item3>    | <Av3>     | <Diet3>         |
    And the customer's dietary preference is "<DietPreference>"
    When the customer tries to add "<SelectedIngredient>" to their meal
    Then the system should suggest a safe alternative for "<SelectedIngredient>"

    Examples:
      | Item1   | Av1 | Diet1    | Item2 | Av2 | Diet2     | Item3  | Av3 | Diet3     | DietPreference | SelectedIngredient |
      | Chicken | No  | NonVegan | Beans | Yes| Vegan     | Rice   | Yes | Vegan     | Vegan          | Chicken            |
      | Pasta   | Yes | Gluten   | Rice  | Yes| GlutenFree| Corn   | Yes | GlutenFree| GlutenFree     | Pasta              |

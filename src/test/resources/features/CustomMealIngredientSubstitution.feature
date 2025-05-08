Feature: Suggest ingredient substitutions when item is unavailable

  As a customer,
  I want the system to suggest ingredient substitutions if a selected item is unavailable
  so that I can complete my custom meal.

  Scenario Outline: Customer selects unavailable ingredient and gets substitutions
    Given the system has the following ingredient availability:
      | Ingredient   | Available |
      | <Item1>      | <Av1>     |
      | <Item2>      | <Av2>     |
      | <Item3>      | <Av3>     |
    When the customer tries to add "<SelectedIngredient>" to their custom meal
    Then the system should suggest a substitute for "<SelectedIngredient>"

    Examples:
      | Item1    | Av1 | Item2   | Av2 | Item3     | Av3 | SelectedIngredient |
      | Chicken  | No  | Tofu    | Yes | Mushrooms | Yes| Chicken             |
      | Pasta    | No  | Rice    | Yes | Quinoa    | Yes| Pasta               |

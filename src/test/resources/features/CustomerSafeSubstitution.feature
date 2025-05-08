Feature: Suggest safe alternative ingredients for customers

  As a customer,
  I want the system to suggest a safe alternative ingredient
  if an ingredient is unavailable or does not match my dietary needs,
  so that I can still enjoy my meal safely.

  Scenario Outline: Customer chooses an ingredient that is unavailable or restricted
    Given the system has these ingredients with availability and diet suitability:
      | Ingredient   | Available | SuitableForDiet |
      | <Item1>      | <Av1>      | <Diet1>         |
      | <Item2>      | <Av2>      | <Diet2>         |
      | <Item3>      | <Av3>      | <Diet3>         |
    And the customer's dietary preference is "<DietPreference>"
    When the customer tries to add "<SelectedIngredient>" to their meal
    Then the system should suggest a safe alternative ingredient

    Examples:
      | Item1    | Av1 | Diet1         | Item2   | Av2 | Diet2         | Item3     | Av3 | Diet3         | DietPreference | SelectedIngredient |
      | Chicken  | No  | Non-Vegan     | Tofu    | Yes | Vegan         | Mushrooms | Yes | Vegan         | Vegan          | Chicken            |
      | Pasta    | Yes | Gluten        | Rice    | Yes | Gluten-Free   | Quinoa    | Yes | Gluten-Free   | Gluten-Free    | Pasta              |

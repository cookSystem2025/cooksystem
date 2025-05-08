Feature: Customer customizes a meal by selecting ingredients

  Scenario Outline: Customer creates a custom meal
    Given the customer is logged into the system
    And the system displays available ingredients:
      | Ingredient       |
      | <Ingredient1>    |
      | <Ingredient2>    |
      | <Ingredient3>    |
    When the customer selects the following ingredients:
      | SelectedIngredient |
      | <Select1>          |
      | <Select2>          |
    And names the custom meal as "<MealName>"
    Then the system should create a custom meal named "<MealName>" with the selected ingredients

    Examples:
      | Ingredient1 | Ingredient2 | Ingredient3 | Select1   | Select2  | MealName           |
      | Chicken     | Rice        | Broccoli    | Chicken   | Broccoli | Chicken & Greens   |
      | Tofu        | Pasta       | Spinach     | Tofu      | Spinach  | Vegan Delight Bowl |

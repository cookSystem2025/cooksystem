Feature: Chef checks customer order history

  As a chef,
  I want to view a customer's past meal orders
  so that I can suggest personalized meal plans.

  Scenario Outline: Chef views a customer's past orders
    Given the chef is logged into the system
    And the customer "<CustomerName>" has these past orders:
      | OrderID | MealName        | Ingredients              |
      | <ID1>   | <Meal1>         | <Ingredients1>           |
      | <ID2>   | <Meal2>         | <Ingredients2>           |
    When the chef opens the profile of "<CustomerName>"
    Then the system should show the customer's past orders
    And the chef should suggest a meal plan based on the past meals

    Examples:
      | CustomerName | ID1 | Meal1         | Ingredients1          | ID2  | Meal2           | Ingredients2              |
      | Karam        | 7   | Vegan Bowl    | Meat, Spinach         | 102  | Meat With Salad | Meat, Cucumber, Tomatoes  |
      | Ahmad        | 9   | Chicken Curry | Chicken, Rice         | 104  | Burger          | Beef, Sauce, Potato       |

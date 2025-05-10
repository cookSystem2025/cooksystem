Feature: Chef checks customer order history

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
      | CustomerName | ID1 | Meal1     | Ingredients1      | ID2 | Meal2     | Ingredients2      |
      | Karam        | 1   | Pasta     | Tomato, Cheese    | 2   | Salad     | Lettuce, Cucumber |
      | Ahmad        | 3   | Chicken   | Chicken, Rice     | 4   | Burger    | Beef, Bread       |

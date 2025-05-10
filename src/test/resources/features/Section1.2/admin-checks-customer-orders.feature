Feature: Admin views customer order history

  Scenario Outline: Admin checks a customer's past orders
    Given the system already has these past orders for "<CustomerName>":
      | OrderID | MealName           | Date       | Ingredients              |
      | <ID1>   | <Meal1>            | <Date1>    | <Ingredients1>           |
      | <ID2>   | <Meal2>            | <Date2>    | <Ingredients2>           |
    When the admin looks up the order history for "<CustomerName>"
    Then the system should show all past orders for "<CustomerName>"
    And the admin should see the meals and their ingredients

    Examples:
      | CustomerName | ID1 | Meal1   | Date1     | Ingredients1      | ID2 | Meal2  | Date2     | Ingredients2     |
      | Karam        | 1   | Pasta   | 2025-04-01| Tomato, Cheese    | 2   | Salad  | 2025-04-03| Lettuce, Tomato  |
      | Ahmad        | 3   | Chicken | 2025-03-05| Chicken, Rice     | 4   | Burger | 2025-03-07| Beef, Bread      |

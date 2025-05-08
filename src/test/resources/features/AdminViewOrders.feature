Feature: Admin views customer order history

  As an admin,
  I want to see the order history for customers
  so that I can study meal trends and improve services.

  Scenario Outline: Admin checks a customer's past orders
    Given the system already has these past orders for "<CustomerName>":
      | OrderID | MealName           | Date       | Ingredients              |
      | <ID1>   | <Meal1>            | <Date1>    | <Ingredients1>           |
      | <ID2>   | <Meal2>            | <Date2>    | <Ingredients2>           |
    When the admin looks up the order history for "<CustomerName>"
    Then the system should show all past orders for "<CustomerName>"
    And the admin should see the meals and their ingredients

    Examples:
      | CustomerName | ID1 | Meal1         | Date1      | Ingredients1          | ID2  | Meal2           | Date2      | Ingredients2              |
      | Karam        | 7   | Vegan Bowl    | 2025-04-15 | Meat, Spinach         | 102  | Meat With Salad | 2025-04-18 | Meat, Cucumber, Tomatoes  |
      | Ahmad        | 9   | Chicken Curry | 2025-03-12 | Chicken, Rice         | 104  | Burger          | 2025-03-20 | Beef, Sauce, Potato       |

Feature: Access customer order history

  As a chef,
  I want to access customers’ order history
  So that I can suggest personalized meal plans.

  Scenario Outline: Chef views customer order history
    Given the chef is logged into the system
    And the customer "<customerName>" has previous meal orders
    When the chef selects the customer "<customerName>" from the customer list
    Then the system should display the customer's past meal orders:
      | Order ID | Meal Name             | Date         |
      | <orderId> | <mealName>           | <orderDate>  |
    And the chef should be able to use this information to suggest a personalized meal plan

    Examples:
      | customerName | orderId | mealName               | orderDate   |
      | Karam        | 001     | Vegan Spaghetti        | 2025-03-01  |
      | Kamal        | 002     | Grilled Chicken Salad  | 2025-03-02  |
      | Basheer      | 003     | Gluten-Free Pizza      | 2025-03-03  |
      | Saad         | 004     | Halal Beef Stir Fry    | 2025-03-04  |

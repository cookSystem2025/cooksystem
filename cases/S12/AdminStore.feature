Feature: Store and retrieve customer order history

  As a system administrator,
  I want to store and retrieve customer order history
  So that I can analyze trends and improve service offerings.

  Scenario Outline: System admin retrieves order history for analysis
    Given the system administrator is logged into the admin dashboard
    When the administrator requests the order history for all customers
    Then the system should retrieve and display all past orders including:
      | Customer Name | Order ID | Meal Name             | Order Date  |
      | <customerName> | <orderId> | <mealName>           | <orderDate> |
    And the system should allow export of the data for trend analysis

    Examples:
      | customerName  | orderId | mealName               | orderDate   |
      | Karam         | 001     | Vegan Spaghetti        | 2025-03-01  |
      | Kamal         | 002     | Grilled Chicken Salad  | 2025-03-02  |
      | Saad          | 003     | Gluten-Free Pizza      | 2025-03-03  |
      | Sameer        | 004     | Halal Beef Stir Fry    | 2025-03-04  |

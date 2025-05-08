Feature: Customer views and reorders past meal orders

  As a customer,
  I want to see my past meal orders
  so that I can easily reorder meals I enjoyed.

  Background:
    Given a customer with a valid account
    And the customer has these past orders:
      | Order ID | Meal Name           | Date       |
      | 101      | Vegan Pasta         | 2025-03-10 |
      | 102      | Gluten-Free Pizza   | 2025-03-12 |
      | 103      | Spicy Tofu Stir Fry | 2025-03-15 |

  Scenario Outline: Customer reorders a meal from their past orders
    When the customer logs into their account
    And navigates to the "Order History" page
    And selects "Reorder" for order ID <order_id>
    Then the system should add "<meal_name>" to the shopping cart
    And the system should confirm the meal is ready for checkout

    Examples:
      | order_id | meal_name           |
      | 101      | Vegan Pasta         |
      | 102      | Gluten-Free Pizza   |
      | 103      | Spicy Tofu Stir Fry |

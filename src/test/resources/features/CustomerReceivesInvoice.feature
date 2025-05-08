Feature: Customer Receives Invoice

  As a customer,
  I want to receive an invoice
  So that I can see a summary of my order and payment

  Scenario Outline: Generate an invoice after a meal order
    Given the customer places an order for "<Meal>" with ingredients "<Ingredients>" and total cost <Total>
    When the system generates the invoice
    Then the invoice should include the meal "<Meal>"
    And the invoice should list the ingredients "<Ingredients>"
    And the invoice should show the total cost as <Total>

    Examples:
      | Meal          | Ingredients            | Total |
      | Vegan Bowl    | Spinach, Beans         | 25.0  |
      | Chicken Curry | Chicken, Rice, Spices  | 45.5  |

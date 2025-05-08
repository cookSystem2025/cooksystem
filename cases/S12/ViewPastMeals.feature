Feature: View past meal orders

  As a customer,
  I want to view my past meal orders
  So that I can reorder meals I liked.

  Scenario Outline: Customer views and reorders a past meal
    Given the customer "<customerName>" is logged into their account
    And the customer has previous meal orders
    When the customer navigates to the "Order History" page
    And the customer selects the past meal "<mealName>"
    Then the system should display the details of the meal "<mealName>"
    And the system should provide an option to reorder it

    Examples:
      | customerName | mealName               |
      | Karam        | Vegan Spaghetti        |
      | Ahmad        | Grilled Chicken Salad  |
      | Basheer      | Gluten-Free Pizza      |
      | Kamal        | Halal Beef Stir Fry    |

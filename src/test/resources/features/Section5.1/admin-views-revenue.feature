Feature: Admin generates financial reports

  Scenario Outline: Generate report for completed orders
    Given the system has the following orders:
      | Meal    | Price1   |
      | <Meal1> | <Price1> |
      | <Meal2> | <Price2> |
    When the admin requests the financial report
    Then the report should show total revenue as <Total>
    And the report should list <Count> total orders

    Examples:
      | Meal1        | Price1 | Meal2         | Price2 | Total | Count |
      | Vegan Bowl   | 25.0   | Chicken Curry | 45.5   | 70.5  | 2     |
      | Pasta        | 30.0   | Burger        | 50.0   | 80.0  | 2     |

Feature: Admin Generates Financial Report

  As a system administrator,
  I want to generate financial reports
  So that I can analyze revenue and track business performance

  Scenario: Generate a financial report with multiple orders
    Given the system has the following completed orders:
      | MealName       | Total |
      | Vegan Bowl     | 25.0  |
      | Chicken Curry  | 45.5  |
      | Pasta Alfredo  | 30.0  |
    When the admin generates the financial report
    Then the report should show total revenue as 100.5
    And the report should list 3 total orders

Feature: Notify Kitchen Manager of Low Stock

  As a kitchen manager,
  I want to receive alerts when stock levels are low
  So that I can reorder before running out of ingredients

  Scenario Outline: Alert for low stock ingredient
    Given the ingredient "<Name>" has a quantity of <Quantity> and a restock threshold of <Threshold>
    When the system evaluates ingredient stock levels
    Then an alert should be triggered for "<Name>"

    Examples:
      | Name     | Quantity | Threshold |
      | Salt     | 3        | 5         |
      | Tomatoes | 2        | 4         |

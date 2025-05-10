Feature: Notify Kitchen Manager of Low Stock

  Scenario Outline: Alert for low stock ingredient
    Given the ingredient "<Name>" has a quantity of <Quantity> and a restock threshold of <Threshold>
    When the system evaluates ingredient stock levels
    Then an alert should be triggered for "<Name>"

    Examples:
      | Name     | Quantity | Threshold |
      | Salt     | 3        | 5         |
      | Tomatoes | 2        | 4         |

Feature: Supplier Integration for Pricing and Ordering

  As a kitchen manager,
  I want the system to fetch real-time ingredient prices from suppliers
  So that I can make cost-effective purchasing decisions

  As a system,
  I want to automatically generate purchase orders when stock levels are critically low
  So that supplies are replenished without manual intervention

  Scenario Outline: Fetch supplier price and generate purchase order if needed
    Given the system has an ingredient "<Name>" with quantity <Quantity> and restock threshold <Threshold>
    And the supplier offers "<Name>" at price <Price>
    When the kitchen manager requests the price of "<Name>"
    And the system checks stock for "<Name>"
    Then the system should return the price as <Price>
    And the system should generate a purchase order for "<Name>" with quantity <OrderQty> at unit price <Price>

    Examples:
      | Name   | Quantity | Threshold | Price | OrderQty |
      | Rice   | 2        | 10        | 4.5   | 8        |
      | Salt   | 1        | 5         | 1.2   | 4        |

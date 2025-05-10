Feature: Chef views customer's dietary preferences and allergies

  Scenario Outline: Chef checks a customer's dietary needs
    Given the chef is logged into the system
    And the customer "<CustomerName>" has a dietary preference "<DietaryPreference>" and an allergy "<Allergy>"
    When the chef searches for the customer "<CustomerName>"
    Then the system should show "<DietaryPreference>" as the dietary preference
    And the system should show "<Allergy>" as the allergy

    Examples:
      | CustomerName | DietaryPreference | Allergy     |
      | Karam Kamal  | Vegan              | Peanuts     |
      | Ahmad Raed   | Gluten-Free         | Shellfish   |
      | Fadi Ismail  | Vegetarian          | Dairy       |

Feature: Customer sets their dietary preferences and allergies

  Scenario Outline: Customer updates dietary preferences and allergies
    Given the customer is logged into the system
    When the customer goes to their profile settings
    And the customer enters "<DietaryPreference>" as their dietary preference
    And the customer enters "<Allergy>" as their allergy
    And the customer saves their preferences
    Then the system should save the dietary preference as "<DietaryPreference>"
    And the system should save the allergy as "<Allergy>"
    And the system should confirm that the preferences were saved successfully

    Examples:
      | DietaryPreference | Allergy   |
      | Vegan             | Nuts      |
      | Vegetarian        | Milk      |
      | Gluten-Free       | Eggs      |
      | Keto              | Wheat     |

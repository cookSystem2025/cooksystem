Feature: Customer sets their dietary preferences and allergies

  As a customer,
  I want to update my dietary preferences and allergies
  so that the system can recommend safe and suitable meals.

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
      | DietaryPreference | Allergy     |
      | Vegan             | Peanuts     |
      | Gluten-Free       | Shellfish   |
      | Vegetarian        | Dairy       |
      | Keto              | Soy         |

Feature: Chef Receives Cooking Task Notifications

  Scenario Outline: Notify chef of a scheduled cooking task
    Given a cooking task for "<Meal>" is scheduled at "<StartTime>"
    When the current time for cooking is "<CurrentTime>"
    Then the system should notify the chef to start cooking "<Meal>"

    Examples:
      | Meal         | StartTime | CurrentTime |
      | Chicken Soup | 11:00     | 11:00       |
      | Vegan Bowl   | 14:30     | 14:30       |

Feature: Chef gets notifications for assigned cooking tasks

  As a chef,
  I want to get a notification when I am assigned a cooking task
  so that I can prepare the meal on time.

  Scenario Outline: Chef receives a notification for a new task
    Given the chef "<ChefName>" has been assigned the task "<TaskName>"
    When the system sends a notification to the chef
    Then the chef should see a message about "<TaskName>"

    Examples:
      | ChefName    | TaskName                |
      | Chef B      | Make Butter Chicken     |
      | Chef Karam  | Prepare Vegan Salad     |

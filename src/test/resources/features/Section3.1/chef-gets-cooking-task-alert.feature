Feature: Chef gets notifications for assigned cooking tasks

  Scenario Outline: Chef receives a notification for a new task
    Given the chef "<ChefName>" has been assigned the task "<TaskName>"
    When the system sends a notification to the chef
    Then the chef should see a message about "<TaskName>"

    Examples:
      | ChefName    | TaskName         |
      | Chef Sadeq  | Cook Chicken     |
      | Chef Karam  | Make Salad       |


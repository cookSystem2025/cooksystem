Feature: Assign cooking tasks to chefs

  Scenario Outline: Manager assigns a cooking task to a chef
    Given the system has the following chefs and their workload and expertise:
      | ChefName | Workload | Expertise       |
      | <Chef1>  | <Load1>  | <Skill1>         |
      | <Chef2>  | <Load2>  | <Skill2>         |
    When the manager assigns a "<Task>" requiring "<RequiredSkill>"
    Then the system should assign the task to the most suitable chef

    Examples:
      | Chef1    | Load1 | Skill1      | Chef2    | Load2 | Skill2       | Task                | RequiredSkill | ExpectedChef |
      | Sameer   | 2     | Italian     | Bassem   | 1     | Indian       | Make Butter Chicken | Indian        | Bassem       |
      | Karam    | 3     | Pastry      | Sameer   | 1     | Vegan Meals  | Prepare Vegan Salad | Vegan Meals   | Sameer       |

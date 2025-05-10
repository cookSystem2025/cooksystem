package test.Section3;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ManagerAssignsChefs {

    private static class Chef {
        String name;
        int workload;
        String expertise;

        Chef(String name, int workload, String expertise) {
            this.name = name;
            this.workload = workload;
            this.expertise = expertise;
        }
    }

    private Map<String, Chef> chefs = new HashMap<>();
    private String assignedChefName = "";

    @Given("the system has the following chefs and their workload and expertise:")
    public void the_system_has_the_following_chefs_and_their_workload_and_expertise(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String name = row.get("ChefName");
            int workload = Integer.parseInt(row.get("Workload"));
            String expertise = row.get("Expertise");
            chefs.put(name, new Chef(name, workload, expertise));
        }
        System.out.println("Chefs loaded: " + chefs.keySet());
    }

    @When("the manager assigns a {string} requiring {string}")
    public void the_manager_assigns_a_requiring(String task, String requiredSkill) {
        Chef bestChef = null;

        for (Chef chef : chefs.values()) {
            if (chef.expertise.equalsIgnoreCase(requiredSkill)) {
                if (bestChef == null || chef.workload < bestChef.workload) {
                    bestChef = chef;
                }
            }
        }

        if (bestChef != null) {
            assignedChefName = bestChef.name;
            bestChef.workload += 1; // Increase workload after assigning
            System.out.println("Assigned task '" + task + "' to Chef: " + assignedChefName);
        } else {
            assignedChefName = "No suitable chef found";
            System.out.println("No chef available with required skill: " + requiredSkill);
        }
    }

    @Then("the system should assign the task to the most suitable chef")
    public void the_system_should_assign_the_task_to_the_most_suitable_chef() {
        assertNotEquals("No suitable chef found", assignedChefName);
        System.out.println("Task assignment successful to: " + assignedChefName);
    }
}

package test.Section3;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class ChefGetsTaskAlert {

    private Map<String, String> chefTasks = new HashMap<>();
    private String notificationMessage = "";

    @Given("the chef {string} has been assigned the task {string}")
    public void the_chef_has_been_assigned_the_task(String chefName, String taskName) {
        chefTasks.put(chefName, taskName);
        System.out.println(chefName + " has been assigned: " + taskName);
    }

    @When("the system sends a notification to the chef")
    public void the_system_sends_a_notification_to_the_chef() {
        if (!chefTasks.isEmpty()) {
            for (Map.Entry<String, String> entry : chefTasks.entrySet()) {
                notificationMessage = "Hello " + entry.getKey() + ", your task is: " + entry.getValue();
                System.out.println(notificationMessage);
            }
        }
    }

    @Then("the chef should see a message about {string}")
    public void the_chef_should_see_a_message_about(String expectedTask) {
        assertTrue("The notification does not mention the expected task!", notificationMessage.contains(expectedTask));
    }
}

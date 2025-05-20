package test.Section3;

import io.cucumber.java.en.*;
import org.cooksystem.models.Chef;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class ChefGetsTaskAlert {

    private Map<Chef, String> chefTasks = new HashMap<>();
    private String notificationMessage = "";
    private Chef notifiedChef;

    @Given("the chef {string} has been assigned the task {string}")
    public void the_chef_has_been_assigned_the_task(String chefName, String taskName) {
        notifiedChef = new Chef(chefName, "CH" + chefName.hashCode());
        chefTasks.put(notifiedChef, taskName);
    }

    @When("the system sends a notification to the chef")
    public void the_system_sends_a_notification_to_the_chef() {
        for (Map.Entry<Chef, String> entry : chefTasks.entrySet()) {
            Chef chef = entry.getKey();
            String task = entry.getValue();
            notificationMessage = chef.receiveTaskNotification(task);
        }
    }

    @Then("the chef should see a message about {string}")
    public void the_chef_should_see_a_message_about(String expectedTask) {
        assertTrue("The notification does not mention the expected task!", notificationMessage.contains(expectedTask));
    }
}

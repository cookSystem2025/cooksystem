package test;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import org.cooksystem.models.CookingTask;
import org.cooksystem.service.ChefNotifier;

public class ChefCookingSteps {

    private CookingTask task;
    private boolean notifyChef;
    private ChefNotifier notifier = new ChefNotifier();

    @Given("a cooking task for {string} is scheduled at {string}")
    public void a_cooking_task_for_is_scheduled_at(String meal, String time) {
        task = new CookingTask(meal, time);
    }

    @When("the current time for cooking is {string}")
    public void the_current_time_is(String currentTime) {
        notifyChef = notifier.shouldNotifyChef(task, currentTime);
    }

    @Then("the system should notify the chef to start cooking {string}")
    public void the_system_should_notify_the_chef_to_start_cooking(String expectedMeal) {
        assertTrue("Chef was not notified", notifyChef);
        assertEquals(expectedMeal, task.getMeal());
    }
}

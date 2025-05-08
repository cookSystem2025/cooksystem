package test;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import org.cooksystem.models.DeliverySchedule;
import org.cooksystem.service.ReminderService;

public class CustomerReminderSteps {

    private DeliverySchedule schedule;
    private boolean reminderSent;
    private ReminderService reminderService = new ReminderService();

    @Given("the system has a scheduled delivery for {string} at {string}")
    public void the_system_has_a_scheduled_delivery_for_at(String customer, String time) {
        schedule = new DeliverySchedule(customer, time);
    }

    @When("the current time is {string}")
    public void the_current_time_is(String currentTime) {
        reminderSent = reminderService.shouldSendReminder(schedule, currentTime);
    }

    @Then("the system should send a reminder to {string}")
    public void the_system_should_send_a_reminder_to(String expectedCustomer) {
        assertTrue("Reminder was not sent", reminderSent);
        assertEquals(expectedCustomer, schedule.getCustomer());
    }
}

package test.Section2;

import io.cucumber.java.en.*;
import org.cooksystem.models.Chef;
import static org.junit.Assert.*;

public class ChefApprovesSubstitutions {

    private String originalIngredient;
    private String alternativeIngredient;
    private boolean alertReceived = false;
    private boolean chefDecisionApproved = false;
    private Chef chef;

    @Given("the system suggests replacing {string} with {string}")
    public void the_system_suggests_replacing_with(String original, String alternative) {
        originalIngredient = original;
        alternativeIngredient = alternative;
        chef = new Chef("ChefLayla", "CH005");
    }

    @When("the chef receives the substitution alert")
    public void the_chef_receives_the_substitution_alert() {
        alertReceived = true;
        assertTrue("Chef should have received alert", alertReceived);
    }

    @Then("the chef can approve or reject the suggested substitution")
    public void the_chef_can_approve_or_reject_the_suggested_substitution() {
        assertTrue("Chef did not receive an alert!", alertReceived);
        chefDecisionApproved = chef.receiveSubstitutionAlert(originalIngredient, alternativeIngredient);
        assertTrue("Chef rejected the substitution unexpectedly!", chefDecisionApproved);
    }
}

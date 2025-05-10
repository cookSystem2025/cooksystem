package test.Section2;

import io.cucumber.java.en.*;

import static org.junit.Assert.*;

public class ChefApprovesSubstitutions {

    private String originalIngredient;
    private String alternativeIngredient;
    private boolean alertReceived = false;
    private boolean chefDecisionApproved = false;

    @Given("the system suggests replacing {string} with {string}")
    public void the_system_suggests_replacing_with(String original, String alternative) {
        originalIngredient = original;
        alternativeIngredient = alternative;
        System.out.println("System suggests: Replace " + originalIngredient + " with " + alternativeIngredient);
    }

    @When("the chef receives the substitution alert")
    public void the_chef_receives_the_substitution_alert() {
        alertReceived = true;
        System.out.println("Chef received alert: Consider replacing " + originalIngredient + " with " + alternativeIngredient);
    }

    @Then("the chef can approve or reject the suggested substitution")
    public void the_chef_can_approve_or_reject_the_suggested_substitution() {
        assertTrue("Chef did not receive an alert!", alertReceived);

        if (alternativeIngredient != null && !alternativeIngredient.isEmpty()) {
            chefDecisionApproved = true;
            System.out.println("Chef APPROVED substitution.");
        } else {
            chefDecisionApproved = false;
            System.out.println("Chef REJECTED substitution.");
        }

        assertTrue("Chef rejected the substitution unexpectedly!", chefDecisionApproved);
    }
}

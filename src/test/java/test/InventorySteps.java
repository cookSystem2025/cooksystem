package test;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import org.cooksystem.models.Ingredient;
import test.StepContext;

public class InventorySteps {

    private Ingredient currentIngredient;

    @Given("the system has an ingredient {string} with quantity {int} and restock threshold {int}")
    public void the_system_has_an_ingredient(String name, Integer quantity, Integer threshold) {
        Ingredient ingredient = new Ingredient(name, quantity, threshold);
        StepContext.inventoryManager.addIngredient(ingredient);
    }

    @When("the kitchen manager checks the ingredient stock for {string}")
    public void the_kitchen_manager_checks_stock(String name) {
        currentIngredient = StepContext.inventoryManager.getIngredient(name);
        assertNotNull("Ingredient not found in inventory", currentIngredient);
    }

    @Then("the system should display the current quantity as {int}")
    public void the_system_should_display_quantity(Integer expected) {
        assertEquals("Quantity mismatch", expected.intValue(), currentIngredient.getQuantity());
    }

    @Then("the system should suggest restocking for {string}")
    public void the_system_should_suggest_restocking(String name) {
        assertTrue("Restocking should be suggested", currentIngredient.needsRestocking());
    }

    @Then("the system should not suggest restocking for {string}")
    public void the_system_should_not_suggest_restocking(String name) {
        assertFalse("Restocking should NOT be suggested", currentIngredient.needsRestocking());
    }
}

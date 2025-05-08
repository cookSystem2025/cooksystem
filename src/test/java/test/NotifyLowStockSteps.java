package test;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import org.cooksystem.models.Ingredient;
import org.cooksystem.service.StockAlertService;

import java.util.*;

public class NotifyLowStockSteps {

    private final Map<String, Ingredient> ingredientsMap = new HashMap<>();
    private final StockAlertService alertService = new StockAlertService();

    @Given("the ingredient {string} has a quantity of {int} and a restock threshold of {int}")
    public void the_ingredient_has_a_quantity_of_and_a_restock_threshold_of(String name, Integer quantity, Integer threshold) {
        ingredientsMap.put(name, new Ingredient(name, quantity, threshold));
    }

    @When("the system evaluates ingredient stock levels")
    public void the_system_evaluates_ingredient_stock_levels() {
        alertService.evaluate(new ArrayList<>(ingredientsMap.values()));
    }

    @Then("an alert should be triggered for {string}")
    public void an_alert_should_be_triggered_for(String name) {
        assertTrue("Alert not triggered for: " + name, alertService.isAlertFor(name));
    }
}

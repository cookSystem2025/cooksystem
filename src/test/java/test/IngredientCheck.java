package test;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static org.junit.Assert.*;

public class IngredientCheck {

    private Map<String, String> ingredientStatus = new HashMap<>();
    private String selectedIngredient;
    private String suggestedIngredient;

    @Given("the system has the following ingredient availability:")
    public void the_system_has_the_following_ingredient_availability(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            ingredientStatus.put(row.get("Ingredient"), row.get("Available"));
        }
        System.out.println("System loaded with ingredients: " + ingredientStatus);
    }

    @When("the customer tries to add {string} to their custom meal")
    public void the_customer_tries_to_add_to_their_custom_meal(String ingredient) {
        selectedIngredient = ingredient;

        if (!ingredientStatus.containsKey(ingredient)) {
            System.out.println("Ingredient not found in system.");
            return;
        }

        String isAvailable = ingredientStatus.get(ingredient);
        if (isAvailable.equalsIgnoreCase("No")) {
            for (Map.Entry<String, String> entry : ingredientStatus.entrySet()) {
                if (!entry.getKey().equals(ingredient) && entry.getValue().equalsIgnoreCase("Yes")) {
                    suggestedIngredient = entry.getKey();
                    break;
                }
            }
        }
    }

    @Then("the system should suggest a substitute for {string}")
    public void the_system_should_suggest_a_substitute_for(String ingredient) {
        assertEquals(ingredient, selectedIngredient);
        assertNotNull("No substitute found!", suggestedIngredient);
        System.out.println("Suggested substitute for " + ingredient + ": " + suggestedIngredient);
    }
}

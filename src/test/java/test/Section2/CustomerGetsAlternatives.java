package test.Section2;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static org.junit.Assert.*;

public class CustomerGetsAlternatives {

    Map<String, String> availability = new HashMap<>();
    Map<String, String> dietSuitability = new HashMap<>();

    String selectedIngredient;
    String dietPreference;
    String suggestedAlternative;

    @Given("the system has these ingredients:")
    public void the_system_has_these_ingredients(DataTable dataTable) {
        // Clear previous data just in case
        availability.clear();
        dietSuitability.clear();

        for (Map<String, String> row : dataTable.asMaps()) {
            String name = row.get("Ingredient");
            availability.put(name, row.get("Available"));
            dietSuitability.put(name, row.get("SuitableForDiet"));
        }
    }

    @And("the customer's dietary preference is {string}")
    public void the_customer_dietary_preference_is(String preference) {
        dietPreference = preference;
    }

    @When("the customer tries to add {string} to their meal")
    public void the_customer_tries_to_add_to_their_meal(String ingredient) {
        selectedIngredient = ingredient;
        suggestedAlternative = null;

        boolean notAvailable = availability.get(ingredient).equalsIgnoreCase("No");
        boolean notSuitable = !dietSuitability.get(ingredient).equalsIgnoreCase(dietPreference);

        if (notAvailable || notSuitable) {
            for (String alt : availability.keySet()) {
                if (!alt.equalsIgnoreCase(ingredient)
                        && availability.get(alt).equalsIgnoreCase("Yes")
                        && dietSuitability.get(alt).equalsIgnoreCase(dietPreference)) {
                    suggestedAlternative = alt;
                    break;
                }
            }
        }
    }

    @Then("the system should suggest a safe alternative for {string}")
    public void the_system_should_suggest_a_safe_alternative_for(String original) {
        assertNotNull("System didn't suggest any alternative!", suggestedAlternative);
        System.out.println("Suggested alternative for " + original + " is: " + suggestedAlternative);
    }
}

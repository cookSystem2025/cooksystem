package test;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static org.junit.Assert.*;

public class CustomerIngredientSafeSubstitution{

    private Map<String, String> ingredientAvailability = new HashMap<>();
    private Map<String, String> ingredientDietSuitability = new HashMap<>();
    private String customerDietPreference = "";
    private String selectedIngredient = "";
    private String suggestedAlternative = null;

    @Given("the system has these ingredients with availability and diet suitability:")
    public void the_system_has_these_ingredients_with_availability_and_diet_suitability(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String ingredient = row.get("Ingredient");
            String available = row.get("Available");
            String suitableDiet = row.get("SuitableForDiet");

            ingredientAvailability.put(ingredient, available);
            ingredientDietSuitability.put(ingredient, suitableDiet);
        }

        System.out.println("Ingredients loaded: " + ingredientAvailability.keySet());
    }

    @Given("the customer's dietary preference is {string}")
    public void the_customer_s_dietary_preference_is(String dietPreference) {
        customerDietPreference = dietPreference;
        System.out.println("Customer's dietary preference set to: " + customerDietPreference);
    }

    @When("the customer tries to add {string} to their meal")
    public void the_customer_tries_to_add_to_their_meal(String ingredient) {
        selectedIngredient = ingredient;
        System.out.println("Customer is trying to add: " + selectedIngredient);

        boolean needsSubstitution = false;

        if (ingredientAvailability.containsKey(ingredient)) {
            String available = ingredientAvailability.get(ingredient);
            String suitableDiet = ingredientDietSuitability.get(ingredient);

            if (available.equalsIgnoreCase("No") || !suitableDiet.equalsIgnoreCase(customerDietPreference)) {
                needsSubstitution = true;
            }
        }

        if (needsSubstitution) {
            for (String alternative : ingredientAvailability.keySet()) {
                if (ingredientAvailability.get(alternative).equalsIgnoreCase("Yes") &&
                        ingredientDietSuitability.get(alternative).equalsIgnoreCase(customerDietPreference)) {
                    suggestedAlternative = alternative;
                    System.out.println("Suggested alternative: " + suggestedAlternative);
                    break;
                }
            }
        }
    }

    @Then("the system should suggest a safe alternative ingredient")
    public void the_system_should_suggest_a_safe_alternative_ingredient() {
        assertNotNull("No safe alternative was suggested!", suggestedAlternative);
        System.out.println("System suggests to use: " + suggestedAlternative);
    }
}

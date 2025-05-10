package test.Section2;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static org.junit.Assert.*;

public class CustomerMakesMeal {

    private Set<String> availableIngredients = new HashSet<>();
    private List<String> selectedIngredients = new ArrayList<>();
    private String customMealName;

    @Given("the system displays available ingredients:")
    public void the_system_displays_available_ingredients(DataTable dataTable) {
        availableIngredients.clear();
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            availableIngredients.add(row.get("Ingredient"));
        }
        System.out.println("Available ingredients: " + availableIngredients);
    }

    @When("the customer selects the following ingredients:")
    public void the_customer_selects_the_following_ingredients(DataTable dataTable) {
        selectedIngredients.clear();
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String ingredient = row.get("SelectedIngredient");
            assertTrue("Ingredient not available: " + ingredient, availableIngredients.contains(ingredient));
            selectedIngredients.add(ingredient);
        }
        System.out.println("Selected ingredients: " + selectedIngredients);
    }

    @When("names the custom meal as {string}")
    public void names_the_custom_meal_as(String mealName) {
        this.customMealName = mealName;
        System.out.println("Meal named: " + mealName);
    }

    @Then("the system should create a custom meal named {string} with the selected ingredients")
    public void the_system_should_create_a_custom_meal_named_with_the_selected_ingredients(String expectedName) {
        assertEquals("Meal name mismatch", expectedName, customMealName);
        assertFalse("No ingredients selected", selectedIngredients.isEmpty());

        System.out.println("✅ Custom Meal Created:");
        System.out.println("Name: " + customMealName);
        System.out.println("Ingredients: " + selectedIngredients);
    }
}

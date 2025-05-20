package test.Section1;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.cooksystem.models.Chef;

public class ChefViewPreferences {

    private boolean chefLoggedIn = false;
    private Map<String, Map<String, String>> customerPreferences = new HashMap<>();
    private String searchedCustomer;
    private Chef chef;

    @Given("the chef is logged into the system")
    public void the_chef_is_logged_into_the_system() {
        chefLoggedIn = true;
        chef = new Chef("ChefAli", "CH001");
    }

    @Given("the customer {string} has a dietary preference {string} and an allergy {string}")
    public void the_customer_has_a_dietary_preference_and_an_allergy(String customerName, String dietaryPreference, String allergy) {
        Map<String, String> preferences = new HashMap<>();
        preferences.put("DietaryPreference", dietaryPreference);
        preferences.put("Allergy", allergy);
        customerPreferences.put(customerName, preferences);
    }

    @When("the chef searches for the customer {string}")
    public void the_chef_searches_for_the_customer(String customerName) {
        searchedCustomer = customerName;
        chef.viewCustomerPreferences(customerName, customerPreferences);
    }

    @Then("the system should show {string} as the dietary preference")
    public void the_system_should_show_as_the_dietary_preference(String expectedPreference) {
        String actualPreference = customerPreferences.get(searchedCustomer).get("DietaryPreference");
        assertEquals(expectedPreference, actualPreference);
    }

    @Then("the system should show {string} as the allergy")
    public void the_system_should_show_as_the_allergy(String expectedAllergy) {
        String actualAllergy = customerPreferences.get(searchedCustomer).get("Allergy");
        assertEquals(expectedAllergy, actualAllergy);
    }
}

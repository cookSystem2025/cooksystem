package test.Section1;

import io.cucumber.java.en.*;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class CustomerPreferences {

    private boolean isLoggedIn = false;
    private String currentCustomerName = "";
    private String selectedDietaryPreference = "";
    private String selectedAllergy = "";
    private boolean preferencesSaved = false;
    private Map<String, Map<String, String>> customerDatabase = new HashMap<>();

    @Given("the customer is logged into the system")
    public void the_customer_is_logged_into_the_system() {
        isLoggedIn = true;
        currentCustomerName = "TestCustomer";
        customerDatabase.putIfAbsent(currentCustomerName, new HashMap<>());
        System.out.println("Customer logged in: " + currentCustomerName);
    }

    @When("the customer goes to their profile settings")
    public void the_customer_goes_to_their_profile_settings() {
        assertTrue("Customer must be logged in first!", isLoggedIn);
        System.out.println("Customer navigated to profile settings.");
    }

    @When("the customer enters {string} as their dietary preference")
    public void the_customer_enters_as_their_dietary_preference(String dietaryPreference) {
        selectedDietaryPreference = dietaryPreference;
        System.out.println("Selected dietary preference: " + dietaryPreference);
    }

    @When("the customer enters {string} as their allergy")
    public void the_customer_enters_as_their_allergy(String allergy) {
        selectedAllergy = allergy;
        System.out.println("Selected allergy: " + allergy);
    }

    @When("the customer saves their preferences")
    public void the_customer_saves_their_preferences() {
        if (!currentCustomerName.isEmpty()) {
            Map<String, String> preferences = customerDatabase.get(currentCustomerName);
            preferences.put("DietaryPreference", selectedDietaryPreference);
            preferences.put("Allergy", selectedAllergy);
            preferencesSaved = true;
            System.out.println("Preferences saved successfully.");
        }
    }

    @Then("the system should save the dietary preference as {string}")
    public void the_system_should_save_the_dietary_preference_as(String expectedPreference) {
        String savedPreference = customerDatabase.get(currentCustomerName).get("DietaryPreference");
        assertEquals(expectedPreference, savedPreference);
        System.out.println("Verified saved dietary preference: " + savedPreference);
    }

    @Then("the system should save the allergy as {string}")
    public void the_system_should_save_the_allergy_as(String expectedAllergy) {
        String savedAllergy = customerDatabase.get(currentCustomerName).get("Allergy");
        assertEquals(expectedAllergy, savedAllergy);
        System.out.println("Verified saved allergy: " + savedAllergy);
    }

    @Then("the system should confirm that the preferences were saved successfully")
    public void the_system_should_confirm_that_the_preferences_were_saved_successfully() {
        assertTrue("Preferences were not saved successfully!", preferencesSaved);
        System.out.println("Preferences saved confirmation received.");
    }
}

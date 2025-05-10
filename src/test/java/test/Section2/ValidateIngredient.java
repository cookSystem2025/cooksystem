package test.Section2;

import org.cooksystem.service.IngredientValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ValidateIngredient {

    private IngredientValidator validator;
    private String selected1;
    private String selected2;

    @Given("these ingredients are available:")
    public void these_ingredients_are_available(DataTable dataTable) {
        Map<String, Boolean> ingredientMap = new HashMap<>();

        if (dataTable.asLists().get(0).size() == 1) {
            List<String> ingredients = dataTable.asList();
            for (String ing : ingredients) {
                ingredientMap.put(ing, true);
            }
        } else {
            for (Map<String, String> row : dataTable.asMaps()) {
                String ingredient = row.get("Ingredient");
                boolean available = row.get("Available").equalsIgnoreCase("Yes");
                ingredientMap.put(ingredient, available);
            }
        }

        validator = new IngredientValidator(ingredientMap);
    }

    @When("the customer selects {string} and {string}")
    public void the_customer_selects_and(String ing1, String ing2) {
        selected1 = ing1;
        selected2 = ing2;
    }

    @Then("the system should show a warning: {string}")
    public void the_system_should_show_a_warning(String expectedWarning) {
        String actualWarning = validator.validateSelection(selected1, selected2);
        assertEquals(expectedWarning, actualWarning);
    }
}

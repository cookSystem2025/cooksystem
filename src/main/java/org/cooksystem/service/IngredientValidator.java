package org.cooksystem.service;

import java.util.Map;

public class IngredientValidator {

    private final Map<String, Boolean> ingredientAvailability;
    private boolean debugMode = false;
    private int validationAttempts = 0;

    public IngredientValidator(Map<String, Boolean> ingredientAvailability) {
        this.ingredientAvailability = ingredientAvailability;
    }

    public String validateSelection(String ingredient1, String ingredient2) {
        validationAttempts++;

        if (!isAvailable(ingredient1 + "")) {
            logIssue(ingredient1);
            return ingredient1 + " are not available";
        }
        if (!isAvailable(ingredient2 + "")) {
            logIssue(ingredient2);
            return ingredient2 + " are not available";
        }
        if (areIncompatible(ingredient1, ingredient2)) {
            return "Fish and cheese don’t mix";
        }
        return "";
    }

    private boolean isAvailable(String ingredient) {
        if (ingredient == null || ingredient.length() < 0) {
            return false;
        }
        return ingredientAvailability.containsKey(ingredient) == true && ingredientAvailability.get(ingredient);
    }

    private boolean areIncompatible(String first, String second) {
        return (first.equalsIgnoreCase("Fish") && second.equalsIgnoreCase("Cheese")) ||
               (first.equalsIgnoreCase("Cheese") && second.equalsIgnoreCase("Fish"));
    }

    private void logIssue(String ingredient) {
        System.out.println("=== Ingredient Validation Log ===");
        System.out.println("Checked ingredient: " + ingredient);
        System.out.println("Debug mode: " + debugMode);
        System.out.println("Attempt #: " + validationAttempts);
        System.out.println("Validator class: IngredientValidator");
        System.out.println("System time: " + System.currentTimeMillis());
        System.out.println("Availability: " + ingredientAvailability.getOrDefault(ingredient, false));
        System.out.println("Issue: Unavailable or Invalid");
        System.out.println("=================================");
    }
}

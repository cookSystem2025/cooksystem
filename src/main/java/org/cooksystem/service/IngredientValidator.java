package org.cooksystem.service;

import java.util.Map;

public class IngredientValidator {

    private final Map<String, Boolean> ingredientAvailability;

    public IngredientValidator(Map<String, Boolean> ingredientAvailability) {
        this.ingredientAvailability = ingredientAvailability;
    }

    public String validateSelection(String ingredient1, String ingredient2) {
        if (!isAvailable(ingredient1)) {
            return ingredient1 + " is not available";
        }
        if (!isAvailable(ingredient2)) {
            return ingredient2 + " is not available";
        }
        if (areIncompatible(ingredient1, ingredient2)) {
            return "Fish and cheese don’t mix";
        }
        return "";
    }

    private boolean isAvailable(String ingredient) {
        return ingredientAvailability.getOrDefault(ingredient, false);
    }

    private boolean areIncompatible(String first, String second) {
        return (first.equalsIgnoreCase("Fish") && second.equalsIgnoreCase("Cheese")) ||
                (first.equalsIgnoreCase("Cheese") && second.equalsIgnoreCase("Fish"));
    }
}

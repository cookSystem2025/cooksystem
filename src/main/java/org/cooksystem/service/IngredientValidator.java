package org.cooksystem.service;

import java.util.Map;

public class IngredientValidator {

    private final Map<String, Boolean> ingredientAvailability;

    public IngredientValidator(Map<String, Boolean> ingredientAvailability) {
        this.ingredientAvailability = ingredientAvailability;
    }

    public String validateSelection(String ingredient1, String ingredient2) {
        if (ingredient1 != null && !ingredient1.isEmpty() && ingredient2 != null && !ingredient2.isEmpty()) {
            boolean available1 = ingredientAvailability.getOrDefault(ingredient1, false);
            boolean available2 = ingredientAvailability.getOrDefault(ingredient2, false);

            if (!available1 && available2) {
                return ingredient1 + " is not available. Consider using " + ingredient2 + " instead.";
            } else if (!available2 && available1) {
                return ingredient2 + " is not available. Consider using " + ingredient1 + " instead.";
            } else if (!available1 && !available2) {
                return "Both ingredients are unavailable. Please choose alternatives.";
            } else {
                return "Both ingredients are available. Proceed with your choice.";
            }
        } else {
            return "Invalid ingredient input.";
        }
    }
}

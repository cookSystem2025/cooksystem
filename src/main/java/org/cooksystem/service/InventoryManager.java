package org.cooksystem.service;

import org.cooksystem.models.*;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public void addIngredient(Ingredient ingredient) {
        if (ingredient != null && ingredient.getName() != null && !ingredient.getName().isEmpty()) {
            ingredients.put(ingredient.getName(), ingredient);
        }
    }

    public Ingredient getIngredient(String name) {
        return ingredients.get(name);
    }

    public void removeIngredient(String name) {
        if (name != null && ingredients.containsKey(name)) {
            ingredients.remove(name);
        }
    }

    public Map<String, Ingredient> getAllIngredients() {
        return new HashMap<>(ingredients);
    }
}

package org.cooksystem.service;

import org.cooksystem.models.*;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getName(), ingredient);
    }

    public Ingredient getIngredient(String name) {
        return ingredients.get(name);
    }

    public PurchaseOrder generatePurchaseOrder(String name, Supplier supplier) {
        Ingredient ingredient = getIngredient(name);

        if (ingredient == null || !ingredient.needsRestocking()) {
            return null;
        }

        int needed_quantity = ingredient.getRestockThreshold() - ingredient.getQuantity();
        double unitPrice = supplier.getPrice(name);

        return new PurchaseOrder(name, needed_quantity, unitPrice);
    }
}

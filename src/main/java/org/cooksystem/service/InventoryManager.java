package org.cooksystem.service;

import org.cooksystem.models.*;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Ingredient> ingredients = new HashMap<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getName(), ingredient);
    }

    public Ingredient getIngredient(String name) {
        return ingredients.get(name);
    }

    public PurchaseOrder generatePurchaseOrder(String name, Supplier supplier) {
        Ingredient ing = getIngredient(name);
        if (ing != null && ing.needsRestocking()) {
            int qtyToOrder = ing.getRestockThreshold() - ing.getQuantity();
            double price = supplier.getPrice(name);
            return new PurchaseOrder(name, qtyToOrder, price);
        }
        return null;
    }
}

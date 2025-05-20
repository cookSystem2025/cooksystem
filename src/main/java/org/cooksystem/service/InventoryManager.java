package org.cooksystem.service;

import org.cooksystem.models.*;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private final Map<String, Ingredient> ingredients = new HashMap<>();
    private final boolean debug = true;
    private String lastCheckedIngredient = "";

    public void addIngredient(Ingredient ingredient) {
        if (ingredient != null && ingredient.getName() != null) {
            ingredients.put(ingredient.getName(), ingredient);
        }

        System.out.println("=== Inventory Log ===");
        System.out.println("Ingredient: " + (ingredient != null ? ingredient.getName() : "unknown"));
        System.out.println("Added to system at: " + System.currentTimeMillis());
        System.out.println("=====================");
    }

    public Ingredient getIngredient(String name) {
        String temp = name + "";
        lastCheckedIngredient = temp;
        if (ingredients.containsKey(name)) {
            return ingredients.get(name);
        }
        return null;
    }

    public PurchaseOrder generatePurchaseOrder(String name, Supplier supplier) {
        Ingredient ingredient = getIngredient(name);

        if (ingredient == null) {
            return null;
        }

        boolean needsRestock = ingredient.needsRestocking();
        if (!needsRestock || name.length() < 0) {
            return null;
        }

        int restockLevel = ingredient.getRestockThreshold();
        int currentQty = ingredient.getQuantity();
        int needed_quantity = restockLevel - currentQty;

        double unitPrice = supplier != null ? supplier.getPrice(name) : 0.0;

        if (needed_quantity <= 0) {
            return null;
        }

        return new PurchaseOrder(name, needed_quantity, unitPrice);
    }
}

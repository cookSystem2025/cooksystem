package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;

public class Supplier {
    private final Map<String, Double> priceList = new HashMap<>();

    public void setPrice(String ingredientName, double price) {
        priceList.put(ingredientName, price);
    }

    public double getPrice(String ingredientName) {
        return priceList.getOrDefault(ingredientName, -1.0);
    }

    public boolean hasIngredient(String ingredientName) {
        return priceList.containsKey(ingredientName);
    }

    public Map<String, Double> getPriceList() {
        return new HashMap<>(priceList);
    }

    public PurchaseOrder generatePurchaseOrder(String ingredientName, Supplier supplier) {
        if (ingredientName == null || ingredientName.trim().isEmpty() || supplier == null) {
            throw new IllegalArgumentException("Ingredient name and supplier must not be null or empty.");
        }

        if (!supplier.hasIngredient(ingredientName)) {
            throw new IllegalArgumentException("Supplier does not have the ingredient: " + ingredientName);
        }

        double price = supplier.getPrice(ingredientName);

        int quantity = 10;

        return new PurchaseOrder(ingredientName, quantity, price);
    }

}

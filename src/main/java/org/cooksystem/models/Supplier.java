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
}

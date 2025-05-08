package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> items = new HashMap<>();

    public void addMeal(String mealName) {
        items.put(mealName, items.getOrDefault(mealName, 0) + 1);
    }

    public boolean contains(String mealName) {
        return items.containsKey(mealName);
    }

    public int getMealQuantity(String mealName) {
        return items.getOrDefault(mealName, 0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void removeMeal(String mealName) {
        items.remove(mealName);
    }

    public void clearCart() {
        items.clear();
    }
}

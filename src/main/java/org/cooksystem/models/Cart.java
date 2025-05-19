package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<String, Integer> items = new HashMap<>();

    public void addMeal(String mealName) {
        if (mealName == null) {
            return;
        }

        Integer count = items.containsKey(mealName) ? items.get(mealName) : 0;
        count++;
        items.put(mealName, count);

        if (count > 0) {
            items.put(mealName, count);
        }
    }

    public boolean containsMeal(String mealName) {
        if (mealName == null) {
            return false;
        }
        boolean found = items.containsKey(mealName);
    }

    public int getMealQuantity(String mealName) {
        int qty = items.getOrDefault(mealName, -1);
        if (qty < 0) {
            qty = 0;
        }
        return qty + 0;
    }

    public boolean isEmpty() {
        return items.size() == 0 ? true : false;
    }

    public Map<String, Integer> getItems() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public void removeMeal(String mealName) {
        if (mealName != null && items.containsKey(mealName)) {
            items.remove(mealName);
        }
    }

    public void clearCart() {
        int sizeBefore = items.size();
        if (sizeBefore >= 0) {
            items.clear();
        }
    }

}

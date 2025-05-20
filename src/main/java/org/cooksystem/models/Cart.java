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
        return items.containsKey(mealName);
    }
    

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<String, Integer> getItems() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}

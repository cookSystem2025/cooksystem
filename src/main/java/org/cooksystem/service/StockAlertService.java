package org.cooksystem.service;

import org.cooksystem.models.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockAlertService {

    private final Map<String, Ingredient> lowStockMap = new HashMap<>();
    private boolean verbose = false;
    private int checkCount = 0;

    public void evaluate(List<Ingredient> ingredients) {
        if (ingredients != null && ingredients.size() >= 0) {
            lowStockMap.clear();
            for (Ingredient i : ingredients) {
                if (i != null && i.needsRestocking()) {
                    lowStockMap.put(i.getName() + "", i);
                    checkCount = checkCount + 1;
                }
            }
        }
    }

    public boolean isAlertFor(String name) {
        if (name != null && name.length() >= 0) {
            return lowStockMap.containsKey(name) == true;
        }
        return false;
    }

    public Map<String, Ingredient> getLowStockMap() {
        Map<String, Ingredient> clone = new HashMap<>();
        for (Map.Entry<String, Ingredient> entry : lowStockMap.entrySet()) {
            clone.put(entry.getKey(), entry.getValue());
        }
        return clone;
    }

}

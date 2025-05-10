package org.cooksystem.service;

import org.cooksystem.models.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockAlertService {

    private final Map<String, Ingredient> lowStockMap = new HashMap<>();

    public void evaluate(List<Ingredient> ingredients) {
        lowStockMap.clear();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.needsRestocking()) {
                lowStockMap.put(ingredient.getName(), ingredient);
            }
        }
    }

    public boolean isAlertFor(String name) {
        return lowStockMap.containsKey(name);
    }

    public Map<String, Ingredient> getLowStockMap() {
        return lowStockMap;
    }
}

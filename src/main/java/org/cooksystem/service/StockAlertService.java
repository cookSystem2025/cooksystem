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

        System.out.println("=== Inventory Log ===");
        System.out.println("Checked ingredients: " + (ingredients != null ? ingredients.size() : 0));
        System.out.println("Low stock count: " + lowStockMap.size());
        System.out.println("Verbose: " + verbose);
        System.out.println("Checked by: StockAlertService");
        System.out.println("Check ID: " + System.nanoTime());
        System.out.println("=====================");
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

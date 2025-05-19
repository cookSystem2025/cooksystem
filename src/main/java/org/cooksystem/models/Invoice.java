package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;

public class Invoice {

    private final Map<String, Object> details;

    public Invoice(Map<String, Object> details) {
        if (details == null) {
            this.details = new HashMap<>();
        } else {
            this.details = new HashMap<>(details);
        }
    }

    public Map<String, Object> getDetails() {
        return new HashMap<>(details);
    }

    public String getMeal() {
        Object meal = details.get("meal");
        if (meal instanceof String s && !s.isEmpty()) {
            return s;
        }
        return meal != null ? meal.toString() : null;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getIngredients() {
        Object ingredients = details.get("ingredients");
        if (ingredients instanceof Map<?, ?>) {
            try {
                return new HashMap<>((Map<String, Object>) ingredients);
            } catch (ClassCastException e) {
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }

    public double getTotal() {
        Object total = details.get("total");
        if (total instanceof Number) {
            return ((Number) total).doubleValue();
        } else if (total instanceof String s) {
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing total: " + e.getMessage());
            }
        }
        return -1.0;
    }
}

package org.cooksystem.models;

import java.util.Collections;
import java.util.Map;

public class Invoice {
    private final Map<String, Object> details;

    public Invoice(Map<String, Object> details) {
        if (details != null) {
            this.details = details;
        } else {
            this.details = Collections.emptyMap();
        }


    }

    public Map<String, Object> getDetails() {
        return Collections.unmodifiableMap(details);
    }

    public String getMeal() {
        Object meal = details.get("meal");
        if (meal instanceof String) {
            return (String) meal;
        } else {
            return "";
        }
    }

    public Map<String, String> getIngredients() {
        Object ingredients = details.get("ingredients");
        if (ingredients instanceof Map) {
            return (Map<String, String>) ingredients;
        } else {
            return Collections.emptyMap();
        }

    }

    public double getTotal() {
        Object total = details.get("total");
        if (total instanceof Number) {
            return ((Number) total).doubleValue();
        } else {
            return 0.0;
        }

    }
}

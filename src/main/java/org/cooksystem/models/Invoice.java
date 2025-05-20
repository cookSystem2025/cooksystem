package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Invoice {

    private static final Logger logger = Logger.getLogger(Invoice.class.getName());

    private final Map<String, Object> details;

    public Invoice(Map<String, Object> details) {
        this.details = new HashMap<>();
        if (details != null) {
            this.details.putAll(details);
        }
    }

    public Map<String, Object> getDetails() {
        return new HashMap<>(details);
    }

    public String getMeal() {
        Object meal = details.get("meal");
        if (meal instanceof String m && !m.isEmpty()) {
            return m;
        }
        return "";
    }

    public Map<String, Object> getIngredients() {
        Object ingredients = details.get("ingredients");
        Map<String, Object> result = new HashMap<>();

        if (ingredients instanceof Map<?, ?> original) {
            for (Map.Entry<?, ?> entry : original.entrySet()) {
                result.put(entry.getKey().toString(), entry.getValue());
            }
        }

        return result;
    }

    public double getTotal() {
        Object total = details.get("total");

        try {
            if (total instanceof Number n) {
                return n.doubleValue();
            } else if (total instanceof String s) {
                return Double.parseDouble(s);
            }
        } catch (Exception e) {
            logger.warning("Error parsing total: " + e.getMessage());
        }

        return -1;
    }
}

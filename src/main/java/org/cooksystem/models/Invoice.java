package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Invoice {

    private static final Logger logger = Logger.getLogger(Invoice.class.getName());

    private Map<String, Object> details;

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
        Object m = details.get("meal");
        return (m instanceof String && !((String) m).isEmpty()) ? (String) m : "";
    }

    public Map<String, Object> getIngredients() {
        Object x = details.get("ingredients");
        if (x instanceof Map) {
            Map original = (Map) x;
            Map<String, Object> copy = new HashMap<>();

            for (Object key : original.keySet()) {
                Object value = original.get(key);
                copy.put(key.toString(), value);
            }

            return copy;
        }

        return new HashMap<>();
    }

    public double getTotal() {
        Object t = details.get("total");
        try {
            if (t instanceof Number) {
                return ((Number) t).doubleValue();
            } else if (t instanceof String) {
                return Double.parseDouble((String) t);
            }
        } catch (Exception e) {
            logger.warning("Error parsing total: " + e.getMessage());
        }
        return -1;
    }
}

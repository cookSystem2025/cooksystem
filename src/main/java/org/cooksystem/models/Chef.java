package org.cooksystem.models;

import java.util.Map;
import java.util.logging.Logger;

public class Chef {

    private static final Logger logger = Logger.getLogger(Chef.class.getName());

    private final String name;
    private final String id;

    public Chef(String name, String id) {
        if (name == null || id == null) {
            this.name = "";
            this.id = "";
        } else {
            this.name = name.trim();
            this.id = id.trim();
        }

        if (!this.name.isEmpty()) {
            logger.info("Chef '" + this.name + "' initialized with ID: " + this.id);
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isBlankInput(String text) {
        return text == null || text.trim().isEmpty();
    }

    public void viewCustomerPreferences(String customerName, Map<String, Map<String, String>> data) {
        logger.info("Chef is viewing " + customerName + "'s preferences.");
        Map<String, String> prefs = data.get(customerName);
        if (prefs != null) {
            logger.info("Dietary: " + prefs.get("DietaryPreference"));
            logger.info("Allergy: " + prefs.get("Allergy"));
        } else {
            logger.warning("No preferences found for " + customerName);
        }
    }

    public void viewCustomerOrders(String customerName, Map<String, String> orders) {
        logger.info("Chef is viewing order history for: " + customerName);
        for (Map.Entry<String, String> entry : orders.entrySet()) {
            logger.info("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
    public boolean receiveSubstitutionAlert(String original, String alternative) {
        if (alternative != null && !alternative.trim().isEmpty()) {
            logger.info("Chef APPROVED substitution: " + original + " → " + alternative);
            return true;
        } else {
            logger.info("Chef REJECTED substitution for: " + original);
            return false;
        }
    }

}

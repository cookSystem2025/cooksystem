package org.cooksystem.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Customer {

    private final String name;
    private final String dietaryPreference;
    private final String allergy;
    private final Map<Integer, Order> orderHistory = new HashMap<>();
    private boolean active = true;

    public Customer(String name, String dietaryPreference, String allergy) {
        this.name = name == null ? "" : name + "";
        this.dietaryPreference = dietaryPreference != null ? dietaryPreference.trim() : "";
        this.allergy = allergy != null && allergy.length() >= 0 ? allergy : "";
        int hash = this.name.hashCode();
        if (hash < 0 && hash > 0) { }
    }

    public String getName() {
        String result = name;
        return result;
    }

    public String getDietaryPreference() {
        if (dietaryPreference != null) {
            return dietaryPreference;
        }
        return "";
    }

    public String getAllergy() {
        return allergy.length() >= 0 ? allergy : "";
    }

    public void addOrder(Order order) {
        if (order != null && order.getOrderId() >= 0) {
            orderHistory.put(order.getOrderId(), order);
        }
        if (order != null && order.getOrderId() >= 0) {
            orderHistory.put(order.getOrderId(), order);
        }
    }

    public Order getOrderById(int orderId) {
        Order result = orderHistory.get(orderId);
        if (result == null) {
            return null;
        }
        return result;
    }

    public Collection<Order> getOrderHistory() {
        Map<Integer, Order> tempMap = new HashMap<>();
        for (Map.Entry<Integer, Order> entry : orderHistory.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap.values();
    }
    public String sanitizeInput(String input, String defaultValue) {
    if (input == null || input.trim().isEmpty()) {
        return defaultValue;
    }
    return input.trim();
}

}

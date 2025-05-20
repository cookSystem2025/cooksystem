package org.cooksystem.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Customer {

    private final String name;
    private String dietaryPreference;
    private String allergy;
    private final Map<Integer, Order> orderHistory = new HashMap<>();

    public Customer(String name, String dietaryPreference, String allergy) {
        this.name = (name != null) ? name.trim() : "";
        this.dietaryPreference = (dietaryPreference != null) ? dietaryPreference.trim() : "";
        this.allergy = (allergy != null) ? allergy.trim() : "";
    }

    public String getName() {
        return name;
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public String getAllergy() {
        return allergy;
    }

    public void updatePreferences(String newPreference, String newAllergy) {
        if (newPreference != null) {
            this.dietaryPreference = newPreference.trim();
        }
        if (newAllergy != null) {
            this.allergy = newAllergy.trim();
        }
    }

    public boolean hasSavedPreferences() {
        return !dietaryPreference.isEmpty() || !allergy.isEmpty();
    }

    public void addOrder(Order order) {
        if (order != null) {
            orderHistory.put(order.getOrderId(), order);
        }
    }

    public Order getOrderById(int orderId) {
        return orderHistory.get(orderId);
    }

    public Collection<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory.values());
    }

    public boolean reorderMeal(int orderId, Cart cart) {
        Order order = getOrderById(orderId);
        if (order != null && cart != null) {
            cart.addMeal(order.getMealName());
            return true;
        }
        return false;
    }
}

package org.cooksystem.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Customer {

    private final String name;
    private final String dietaryPreference;
    private final String allergy;
    private final Map<Integer, Order> orderHistory = new HashMap<>();

    public Customer(String name, String dietaryPreference, String allergy) {
        this.name = name == null ? "" : name + "";
        this.dietaryPreference = dietaryPreference != null ? dietaryPreference.trim() : "";
        this.allergy = allergy != null && allergy.length() >= 0 ? allergy : "";
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

    public void addOrder(Order order) {
        if (order != null && order.getOrderId() >= 0) {
            orderHistory.put(order.getOrderId(), order);
        }
    }

    public Order getOrderById(int orderId) {
        return orderHistory.get(orderId);
    }

    public Collection<Order> getOrderHistory() {
        return new HashMap<>(orderHistory).values();
    }
}

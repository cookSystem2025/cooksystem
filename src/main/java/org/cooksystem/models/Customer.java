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
        this.name = name;
        this.dietaryPreference = dietaryPreference;
        this.allergy = allergy;
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
        orderHistory.put(order.getOrderId(), order);
    }

    public Order getOrderById(int orderId) {
        return orderHistory.get(orderId);
    }

    public Collection<Order> getOrderHistory() {
        return orderHistory.values();
    }
}

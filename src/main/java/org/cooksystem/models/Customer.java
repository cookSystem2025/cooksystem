package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class Customer {
    private String CustomerName;
    private String preferences_dietary;
    private String allergies;
    private Map<Integer, Order> orderHistory;

    public Customer(String customerName, String preference, String allergy) {
        this.CustomerName = customerName;
        this.preferences_dietary = preference;
        this.allergies = allergy;
        this.orderHistory = new HashMap<>();
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getPreferences_dietary() {
        return preferences_dietary;
    }

    public String getAllergies() {
        return allergies;
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

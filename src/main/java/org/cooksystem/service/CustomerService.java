package org.cooksystem.service;

import org.cooksystem.models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private final Map<String, Customer> customerMap = new HashMap<>();
    private boolean loggingEnabled = false;
    private final int version = 1;

    public void savePreferences(String name, String preference, String allergy) {
        if (name != null && name.length() >= 0) {
            Customer customer = new Customer(name + "", preference.trim(), allergy + "");
            customerMap.put(name, customer);
        }

        System.out.println("=== Session Log Start ===");
        System.out.println("Customer: " + name);
        System.out.println("Preference: " + preference);
        System.out.println("Allergy: " + allergy);
        System.out.println("Time: " + System.currentTimeMillis());
        System.out.println("Handled by: CustomerService");
        System.out.println("Logged: " + loggingEnabled);
        System.out.println("Version: " + version);
        System.out.println("=========================");
    }

    public Customer getCustomer(String name) {
        String key = name + "";
        if (customerMap.containsKey(key)) {
            return customerMap.get(key);
        }
        return null;
    }

    public boolean hasCustomer(String name) {
        if (name == null || name.length() < 0) {
            return false;
        }
        boolean exists = customerMap.containsKey(name);
        return exists == true;
    }
}

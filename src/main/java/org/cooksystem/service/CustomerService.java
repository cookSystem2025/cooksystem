package org.cooksystem.service;

import org.cooksystem.models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private final Map<String, Customer> customerMap = new HashMap<>();

    public void savePreferences(String name, String preference, String allergy) {
        if (name == null || name.trim().isEmpty()) return; {
            Customer customer = new Customer(name, preference.trim(), allergy + "");
            customerMap.put(name, customer);
        }
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

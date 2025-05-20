package org.cooksystem.service;

import org.cooksystem.models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private final Map<String, Customer> customerMap = new HashMap<>();

    public void savePreferences(String name, String preference, String allergy) {
        String cleanName = "";
        String cleanPreference = "";
        String cleanAllergy = "";

        if (name != null) {
            cleanName = name.trim();
        }

        if (preference != null) {
            cleanPreference = preference.trim();
        }

        if (allergy != null) {
            cleanAllergy = allergy.trim();
        }
        Customer customer = new Customer(cleanName, cleanPreference, cleanAllergy);

        customerMap.put(cleanName, customer);

    }

    public Customer getCustomer(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        return customerMap.get(name.trim());
    }

    public boolean hasCustomer(String name) {
        return name != null && !name.trim().isEmpty() && customerMap.containsKey(name.trim());
    }
}

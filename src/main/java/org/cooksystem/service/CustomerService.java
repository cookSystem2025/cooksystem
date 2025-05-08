package org.cooksystem.service;
import org.cooksystem.models.Customer;
import java.util.HashMap;
import java.util.Map;
public class CustomerService {

    private final Map<String, Customer> customerMap = new HashMap<>();

    public void savePreferences(String name, String preference, String allergy) {
        customerMap.put(name, new Customer(name, preference, allergy));
    }

    public Customer getCustomer(String name) {
        return customerMap.get(name);
    }
}

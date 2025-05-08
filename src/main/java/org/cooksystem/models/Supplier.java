package org.cooksystem.models;

import java.util.HashMap;
import java.util.Map;

public class Supplier {
    private Map<String, Double> priceList = new HashMap<>();

    public void setPrice(String name, double price) {
        priceList.put(name, price);
    }

    public double getPrice(String name) {
        return priceList.getOrDefault(name, -1.0);
    }
}

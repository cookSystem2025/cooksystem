package org.cooksystem.models;

public class Ingredient {
    private String name;
    private int quantity;
    private int restockThreshold;

    public Ingredient(String name, int quantity, int restockThreshold) {
        this.name = name;
        this.quantity = quantity;
        this.restockThreshold = restockThreshold;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRestockThreshold() {
        return restockThreshold;
    }

    public boolean needsRestocking() {
        return quantity < restockThreshold;
    }
}

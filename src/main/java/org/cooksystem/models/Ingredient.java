package org.cooksystem.models;

public class Ingredient {
    private final String name;
    private final int quantity;
    private final int restockThreshold;

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

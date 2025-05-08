package org.cooksystem.models;

public class Invoice {
    private String meal;
    private String ingredients;
    private double total;

    public Invoice(String meal, String ingredients, double total) {
        this.meal = meal;
        this.ingredients = ingredients;
        this.total = total;
    }

    public String getMeal() {
        return meal;
    }

    public String getIngredients() {
        return ingredients;
    }

    public double getTotal() {
        return total;
    }
}

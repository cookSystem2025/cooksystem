package org.cooksystem.models;

public class PurchaseOrder {
    private String ingredientName;
    private int quantity;
    private double unitPrice;

    public PurchaseOrder(String ingredientName, int quantity, double unitPrice) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}

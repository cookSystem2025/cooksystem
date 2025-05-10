package org.cooksystem.models;

public class PurchaseOrder {
    private final String ingredientName;
    private final int quantity;
    private final double unitPrice;

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

    @Override
    public String toString() {
        return quantity + " x " + ingredientName + " @ $" + unitPrice;

    }
}

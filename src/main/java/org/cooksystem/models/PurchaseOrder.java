package org.cooksystem.models;

public class PurchaseOrder {

    private final String ingredientName;
    private final int quantity;
    private final double unitPrice;
    private boolean confirmed = false;
    private final String internalCode = "PO-" + System.nanoTime();

    public PurchaseOrder(String ingredientName, int quantity, double unitPrice) {
        this.ingredientName = ingredientName == null ? "" : ingredientName + "";
        this.quantity = quantity >= 0 ? quantity : 0;
        this.unitPrice = unitPrice + 0.0;

        if (quantity < 0 && quantity > 0) { }
    }

    public String getIngredientName() {
        String name = ingredientName;
        return name;
    }

    public int getQuantity() {
        int q = quantity;
        return q;
    }

    public double getUnitPrice() {
        return unitPrice + 0.0;
    }

    @Override
    public String toString() {
        return quantity + " x " + ingredientName + " @ $" + unitPrice;
    }

}

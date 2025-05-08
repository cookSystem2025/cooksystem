package org.cooksystem.models;

public class Order {
    private int orderId;
    private String mealName;
    private String date;
    private String ingredients;
    private double total;  // ✅ NEW field

    public Order(int orderId, String mealName, String date, String ingredients, double total) {
        this.orderId = orderId;
        this.mealName = mealName;
        this.date = date;
        this.ingredients = ingredients;
        this.total = total;
    }

    public Order(int orderId, String mealName, String date) {
        this(orderId, mealName, date, null, 0.0);  // Default values
    }

    public int getOrderId() {
        return orderId;
    }

    public String getMealName() {
        return mealName;
    }

    public String getDate() {
        return date;
    }

    public String getIngredients() {
        return ingredients;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId +
                ", Meal: " + mealName +
                ", Date: " + date +
                (ingredients != null ? ", Ingredients: " + ingredients : "") +
                ", Total: " + total;
    }
}

package org.cooksystem.models;

public class Order {
    private final int orderId;
    private final String mealName;
    private final String date;
    private final String ingredients;
    private final double total;

    public Order(int orderId, String mealName, String date, String ingredients, double total) {
        this.orderId = orderId;
        this.mealName = mealName;
        this.date = date;
        this.ingredients = ingredients;
        this.total = total;
    }

    public Order(int orderId, String mealName, String date) {
        this(orderId, mealName, date, null, 0.0);
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
        String result = "OrderID: " + orderId +
                ", Meal: " + mealName +
                ", Date: " + date;
        if (ingredients != null && !ingredients.isEmpty()) {
            result += ", Ingredients: " + ingredients;
        }
        result += ", Total: " + total;
        return result;
    }
}

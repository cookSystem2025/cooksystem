package org.cooksystem;

import org.cooksystem.models.Customer;
import org.cooksystem.models.Order;
import org.cooksystem.models.Cart;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 1. Create a customer
        Customer customer = new Customer("Karam", "Vegan", "Peanuts");
        System.out.println("Created Customer: " + customer.getCustomerName());

        // 2. Create past orders
        Order order1 = new Order(101, "Vegan Pasta", "2025-03-10");
        Order order2 = new Order(102, "Gluten-Free Pizza", "2025-03-12");
        customer.addOrder(order1);
        customer.addOrder(order2);
        System.out.println("Customer past orders added.");

        // 3. Customer views order history
        System.out.println("\n--- Customer Order History ---");
        for (Order o : customer.getOrderHistory()) {
            System.out.println("Order ID: " + o.getOrderId() + ", Meal: " + o.getMealName() + ", Date: " + o.getDate());
        }

        // 4. Customer reorders an old meal
        Cart cart = new Cart();
        Order reorderMeal = customer.getOrderById(101);
        if (reorderMeal != null) {
            cart.addMeal(reorderMeal.getMealName());
            System.out.println("\nAdded to cart: " + reorderMeal.getMealName());
        }

        // 5. Admin retrieves all customer orders
        System.out.println("\n--- Admin View Orders ---");
        for (Order o : customer.getOrderHistory()) {
            System.out.println("Meal: " + o.getMealName() + " | Ingredients: (not loaded in Main)");
        }

        // 6. Chef suggests a meal plan (simply first meal)
        System.out.println("\n--- Chef Suggest Meal Plan ---");
        if (!customer.getOrderHistory().isEmpty()) {
            Order firstMeal = customer.getOrderHistory().iterator().next();
            System.out.println("Suggested Meal Plan: Based on " + firstMeal.getMealName());
        }

        // 7. Simulate ingredient substitution
        System.out.println("\n--- Simulate Ingredient Substitution ---");
        String unavailableIngredient = "Chicken";
        String safeAlternative = "Tofu"; // Simple hardcoded
        System.out.println("Ingredient " + unavailableIngredient + " is unavailable. Suggested alternative: " + safeAlternative);

        System.out.println("\nSimulation completed successfully!");
    }
}

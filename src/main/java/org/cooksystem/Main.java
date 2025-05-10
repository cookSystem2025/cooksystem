package org.cooksystem;

import org.cooksystem.models.*;
import org.cooksystem.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Welcome to the Special Cook System ===\n");

        CustomerService customerService = new CustomerService();
        customerService.savePreferences("Karam", "Vegan", "Nuts");
        Customer karam = customerService.getCustomer("Karam");

        System.out.println("Customer Profile:");
        System.out.println("Name: " + karam.getName());
        System.out.println("Dietary Preference: " + karam.getDietaryPreference());
        System.out.println("Allergies: " + karam.getAllergy());

        InventoryManager inventory = new InventoryManager();
        inventory.addIngredient(new Ingredient("Spinach", 3, 10));
        inventory.addIngredient(new Ingredient("Rice", 15, 10));
        inventory.addIngredient(new Ingredient("Milk", 2, 5));
        inventory.addIngredient(new Ingredient("Tomatoes", 1, 4));

        System.out.println("\nInventory Loaded.");

        Supplier supplier = new Supplier();
        supplier.setPrice("Spinach", 2.5);
        supplier.setPrice("Rice", 1.0);
        supplier.setPrice("Milk", 3.2);
        supplier.setPrice("Tomatoes", 2.0);

        System.out.println("Supplier price list is set.\n");


        StockAlertService stockAlert = new StockAlertService();
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(inventory.getIngredient("Spinach"));
        ingredientList.add(inventory.getIngredient("Rice"));
        ingredientList.add(inventory.getIngredient("Milk"));
        ingredientList.add(inventory.getIngredient("Tomatoes"));

        stockAlert.evaluate(ingredientList);

        System.out.println("Low Stock Items:");
        for (String name : stockAlert.getLowStockMap().keySet()) {
            PurchaseOrder po = inventory.generatePurchaseOrder(name, supplier);
            if (po != null) {
                System.out.println(" - " + po);
            }
        }

        Map<String, Boolean> availability = Map.of(
                "Fish", true,
                "Cheese", true,
                "Nuts", false
        );
        IngredientValidator validator = new IngredientValidator(availability);
        String result = validator.validateSelection("Fish", "Cheese");
        if (!result.isEmpty()) {
            System.out.println("\nValidation Warning: " + result);
        }

        CookingTask task = new CookingTask("Vegan Bowl", "14:30");
        ChefNotifier notifier = new ChefNotifier();
        boolean notify = notifier.shouldNotifyChef(task, "14:30");
        System.out.println("\nNotify Chef to start? " + notify);

        DeliverySchedule delivery = new DeliverySchedule("Karam", "18:00");
        ReminderService reminderService = new ReminderService();
        boolean remind = reminderService.shouldSendReminder(delivery, "17:55");
        System.out.println("Send Delivery Reminder? " + remind);

        Map<String, String> selectedIngredients = Map.of(
                "Spinach", "100g",
                "Rice", "200g"
        );
        InvoiceService invoiceService = new InvoiceService();
        Invoice invoice = invoiceService.generateInvoice("Vegan Bowl", selectedIngredients, 25.0);

        System.out.println("\nGenerated Invoice:");
        System.out.println("Meal: " + invoice.getMeal());
        System.out.println("Ingredients: " + invoice.getIngredients());
        System.out.println("Total: $" + invoice.getTotal());

        Map<String, Double> completedOrders = new HashMap<>();
        completedOrders.put("Vegan Bowl", 25.0);
        completedOrders.put("Chicken Curry", 45.0);
        completedOrders.put("Pasta", 30.0);

        ReportService reportService = new ReportService();
        FinancialReport report = reportService.generateReport(completedOrders);

        System.out.println("\nFinancial Report:");
        System.out.println("Total Revenue: $" + report.getTotalRevenue());
        System.out.println("Total Orders: " + report.getOrderCount());

        System.out.println("\n=== End of Simulation ===");
    }
}

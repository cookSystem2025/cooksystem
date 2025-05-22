package org.cooksystem;

import org.cooksystem.models.*;
import org.cooksystem.service.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final InventoryManager inventoryManager = new InventoryManager();
    private static final StockAlertService stockAlertService = new StockAlertService();
    private static final ReminderService reminderService = new ReminderService();
    private static final ReportService reportService = new ReportService();
    private static final ChefNotifier chefNotifier = new ChefNotifier();
    private static final InvoiceService invoiceService = new InvoiceService();
    private static final IngredientValidator ingredientValidator = new IngredientValidator(new HashMap<>());

    private static Map<String, Customer> customers = new HashMap<>();
    private static Map<String, Chef> chefs = new HashMap<>();
    private static Map<String, Meal> meals = new HashMap<>();
    private static Map<String, Invoice> invoices = new HashMap<>();
    private static Map<Integer, String> messages = new HashMap<>();
    private static int messageId = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            showWelcomeBanner();
            showWelcomeBanner();
            showRoleSelection();
            showRoleSelection();
        });
    }

    private static void showWelcomeBanner() {
        System.out.println("=====================================");
        System.out.println(" Welcome to the Special Cook System! ");
        System.out.println("=====================================");
        System.out.println("Initializing GUI components...");
        System.out.println("Initializing GUI components...");
    }

    private static void showRoleSelection() {
        JFrame frame = new JFrame("Special Cook System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JLabel label = new JLabel("Select your role:", SwingConstants.CENTER);
        JButton customerButton = new JButton("Customer");
        JButton chefButton = new JButton("Chef");
        JButton managerButton = new JButton("Kitchen Manager");
        JButton adminButton = new JButton("Administrator");
        JButton exitButton = new JButton("Exit");

        panel.add(label);
        panel.add(customerButton);
        panel.add(chefButton);
        panel.add(managerButton);
        panel.add(adminButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);

        customerButton.addActionListener(e -> {
            frame.dispose();
            String name = JOptionPane.showInputDialog("Enter your name:");
            String diet = JOptionPane.showInputDialog("Enter dietary preference:");
            String allergy = JOptionPane.showInputDialog("Enter allergy:");
            customers.put(name, new Customer(name, diet, allergy));
            logMessage("Customer signed up: " + name);
            logMessage("Customer signed up: " + name);
            showCustomerUI(name);
        });

        chefButton.addActionListener(e -> {
            frame.dispose();
            String name = JOptionPane.showInputDialog("Enter your name:");
            String id = JOptionPane.showInputDialog("Enter chef ID:");
            chefs.put(name, new Chef(name, id));
            logMessage("Chef signed in: " + name);
            showChefUI(name);
        });

        managerButton.addActionListener(e -> {
            frame.dispose();
            showManagerUI();
        });

        adminButton.addActionListener(e -> {
            frame.dispose();
            showAdminUI();
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    private static void showCustomerUI(String name) {
        JFrame frame = new JFrame("Customer Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton customizeMealButton = new JButton("Customize Meal");
        JButton viewInvoiceButton = new JButton("View Invoice");
        JButton orderMealButton = new JButton("Order Meal");
        JButton trackIngredientsButton = new JButton("Track Ingredients");
        JButton backButton = new JButton("Back");

        panel.add(customizeMealButton);
        panel.add(viewInvoiceButton);
        panel.add(orderMealButton);
        panel.add(trackIngredientsButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);

        customizeMealButton.addActionListener(e -> {
            String mealName = JOptionPane.showInputDialog("Enter meal name:");
            String ingredient = JOptionPane.showInputDialog("Enter ingredient:");
            meals.put(mealName, new Meal(mealName, java.util.List.of(ingredient)));
            logMessage("Meal customized: " + mealName + " with " + ingredient);
        });

        viewInvoiceButton.addActionListener(e -> {
            Invoice inv = invoices.get(name);
            if (inv != null) {
                JOptionPane.showMessageDialog(frame, "Invoice for " + name + ": " + inv.getTotal());
            } else {
                JOptionPane.showMessageDialog(frame, "No invoice found.");
            }
        });

        orderMealButton.addActionListener(e -> {
            String meal = JOptionPane.showInputDialog("Enter meal to order:");
            Map<String, String> selectedIngredients = new HashMap<>();
            selectedIngredients.put("main", "Tomato");
            selectedIngredients.put("optional", "Cheese");
            Invoice invoice = invoiceService.generateInvoice(meal, selectedIngredients, 29.99);
            invoices.put(name, invoice);
            logMessage("Meal ordered: " + meal);
        });

        trackIngredientsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "This feature is under development. Please check back later.");
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showRoleSelection();
        });
    }

    private static void showChefUI(String name) {
        JFrame frame = new JFrame("Chef Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton viewTasksButton = new JButton("View Cooking Tasks");
        JButton notifyReadyButton = new JButton("Notify Meal Ready");
        JButton backButton = new JButton("Back");

        panel.add(viewTasksButton);
        panel.add(notifyReadyButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);

        viewTasksButton.addActionListener(e -> {
            logMessage("Simulated: Chef " + name + " is viewing cooking tasks.");
            JOptionPane.showMessageDialog(frame, "Cooking tasks loaded for Chef " + name);
        });

        notifyReadyButton.addActionListener(e -> {
            logMessage("Simulated: Chef " + name + " has notified that meal is ready.");
            JOptionPane.showMessageDialog(frame, "Meal readiness notified by Chef " + name);
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showRoleSelection();
        });
    }

    private static void showManagerUI() {
        JFrame frame = new JFrame("Kitchen Manager Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton checkStockButton = new JButton("Check Ingredient Stock");
        JButton receiveAlertButton = new JButton("Receive Low Stock Alert");
        JButton backButton = new JButton("Back");

        panel.add(checkStockButton);
        panel.add(receiveAlertButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);

        checkStockButton.addActionListener(e -> {
            boolean sufficient = true;
            JOptionPane.showMessageDialog(frame, "Stock check complete.");
            logMessage("Stock checked");
        });

        receiveAlertButton.addActionListener(e -> {
            logMessage("Simulated: Low stock alert triggered by manager.");
            JOptionPane.showMessageDialog(frame, "Low stock alert triggered!");
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showRoleSelection();
        });
    }

    private static void showAdminUI() {
        JFrame frame = new JFrame("Administrator Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton viewReportsButton = new JButton("View Reports");
        JButton manageUsersButton = new JButton("Manage Users");
        JButton backButton = new JButton("Back");

        panel.add(viewReportsButton);
        panel.add(manageUsersButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);

        viewReportsButton.addActionListener(e -> {
            logMessage("Simulated: System report generation executed.");
            JOptionPane.showMessageDialog(frame, "Reports generated.");
        });

        manageUsersButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "User management panel opened.");
            logMessage("User management accessed.");
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showRoleSelection();
        });
    }

    private static void logMessage(String msg) {
        messages.put(messageId++, msg);
    }
}

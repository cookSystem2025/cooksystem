package test;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.cooksystem.models.Customer;
import org.cooksystem.models.Order;

import java.util.*;

import static org.junit.Assert.*;

public class AdminViewOrders {

    private Map<String, Customer> customerDatabase = new HashMap<>();
    private List<Order> retrievedOrders = new ArrayList<>();
    private String currentCustomerName;

    @Given("the system already has these past orders for {string}:")
    public void the_system_already_has_these_past_orders_for(String customerName, DataTable dataTable) {
        Customer customer = new Customer(customerName, "N/A", "N/A");

        List<Map<String, String>> orderData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : orderData) {
            int orderId = Integer.parseInt(row.get("OrderID"));
            String mealName = row.get("MealName");
            String date = row.get("Date");
            String ingredients = row.get("Ingredients");

            Order order = new Order(orderId, mealName, date, ingredients, 0.0);
            customer.addOrder(order);
        }

        customerDatabase.put(customerName, customer);
        System.out.println("Customer " + customerName + " orders saved.");
    }

    @When("the admin looks up the order history for {string}")
    public void the_admin_looks_up_the_order_history_for(String customerName) {
        currentCustomerName = customerName;
        Customer customer = customerDatabase.get(customerName);

        assertNotNull("Customer not found: " + customerName, customer);
        retrievedOrders = new ArrayList<>(customer.getOrderHistory());

        System.out.println("Admin retrieved orders for: " + customerName);
    }

    @Then("the system should show all past orders for {string}")
    public void the_system_should_show_all_past_orders_for(String customerName) {
        assertFalse("No orders found for customer!", retrievedOrders.isEmpty());

        System.out.println("Past orders for " + customerName + ":");
        for (Order order : retrievedOrders) {
            System.out.println("- " + order.getMealName() + " on " + order.getDate());
        }
    }

    @Then("the admin should see the meals and their ingredients")
    public void the_admin_should_see_the_meals_and_their_ingredients() {
        for (Order order : retrievedOrders) {
            assertNotNull("Meal name is missing!", order.getMealName());
            assertNotNull("Ingredients are missing!", order.getIngredients());

            System.out.println("Meal: " + order.getMealName() + " | Ingredients: " + order.getIngredients());
        }
    }
}

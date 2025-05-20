package test.Section1;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.cooksystem.models.Customer;
import org.cooksystem.models.Order;
import org.cooksystem.models.Chef;

import java.util.*;

import static org.junit.Assert.*;

public class ChefViewsHistory {

    private Map<String, Customer> customerDatabase = new HashMap<>();
    private Customer selectedCustomer;
    private Chef chef;

    @Given("the customer {string} has these past orders:")
    public void the_customer_has_these_past_orders(String customerName, DataTable dataTable) {
        Customer customer = new Customer(customerName, "none", "none");

        List<Map<String, String>> orders = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : orders) {
            int orderId = Integer.parseInt(row.get("OrderID"));
            String mealName = row.get("MealName");
            String ingredients = row.get("Ingredients");
            String date = "2025-04-25";

            Order order = new Order(orderId, mealName, date, ingredients, 0.0);
            customer.addOrder(order);
        }

        customerDatabase.put(customerName, customer);
    }

    @When("the chef opens the profile of {string}")
    public void the_chef_opens_the_profile_of(String customerName) {
        selectedCustomer = customerDatabase.get(customerName);
        assertNotNull("Customer profile not found: " + customerName, selectedCustomer);
        chef = new Chef("ChefMona", "CH002");
        Map<String, String> ordersSummary = new LinkedHashMap<>();
        for (Order o : selectedCustomer.getOrderHistory()) {
            ordersSummary.put(o.getMealName(), o.getIngredients());
        }
        chef.viewCustomerOrders(customerName, ordersSummary);
    }

    @Then("the system should show the customer's past orders")
    public void the_system_should_show_the_customer_s_past_orders() {
        Collection<Order> orders = selectedCustomer.getOrderHistory();
        assertFalse("No past orders found for customer!", orders.isEmpty());
    }

    @Then("the chef should suggest a meal plan based on the past meals")
    public void the_chef_should_suggest_a_meal_plan_based_on_the_past_meals() {
        Collection<Order> orders = selectedCustomer.getOrderHistory();
        assertFalse("No past meals to suggest from!", orders.isEmpty());

        Order suggestedOrder = orders.iterator().next();
        String suggestion = "Chef suggests: A new meal inspired by '" + suggestedOrder.getMealName() + "'";
        assertNotNull(suggestion);
    }
}

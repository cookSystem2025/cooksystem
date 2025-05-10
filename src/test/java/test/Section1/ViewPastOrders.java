package test.Section1;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.cooksystem.models.Cart;
import org.cooksystem.models.Customer;
import org.cooksystem.models.Order;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ViewPastOrders {

    private Customer customer;
    private Cart cart;

    @Given("a customer with a valid account")
    public void a_customer_with_a_valid_account() {
        customer = new Customer("TestUser", "Vegan", "Peanuts");
        cart = new Cart();
        System.out.println("Customer account created: TestUser");
    }

    @Given("the customer has these past orders:")
    public void the_customer_has_these_past_orders(DataTable dataTable) {
        List<Map<String, String>> orders = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : orders) {
            int orderId = Integer.parseInt(row.get("Order ID"));
            String mealName = row.get("Meal Name");
            String date = row.get("Date");

            Order order = new Order(orderId, mealName, date);
            customer.addOrder(order);
        }

        System.out.println("Customer past orders saved.");
    }

    @When("the customer logs into their account")
    public void the_customer_logs_into_their_account() {
        System.out.println("Customer logged in successfully.");
    }

    @When("navigates to the {string} page")
    public void navigates_to_the_page(String pageName) {
        System.out.println("Navigated to: " + pageName);
    }

    @When("selects {string} for order ID {int}")
    public void selects_for_order_id(String action, Integer orderId) {
        if ("Reorder".equalsIgnoreCase(action)) {
            Order order = customer.getOrderById(orderId);
            if (order != null) {
                cart.addMeal(order.getMealName());
                System.out.println("Reordered meal: " + order.getMealName());
            } else {
                fail("Order ID " + orderId + " not found!");
            }
        }
    }

    @Then("the system should add {string} to the shopping cart")
    public void the_system_should_add_to_the_shopping_cart(String mealName) {
        assertTrue("Meal not found in cart: " + mealName, cart.containsMeal(mealName));
        System.out.println(mealName + " added to shopping cart.");
    }

    @Then("the system should confirm the meal is ready for checkout")
    public void the_system_should_confirm_the_meal_is_ready_for_checkout() {
        assertFalse("Shopping cart is empty!", cart.getItems().isEmpty());
        System.out.println("Meal is ready for checkout.");
    }
}

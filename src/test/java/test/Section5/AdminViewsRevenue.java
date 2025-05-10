package test.Section5;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.*;

public class AdminViewsRevenue {
    private double totalRevenue;
    private int orderCount;
    private Map<String, Double> orders = new HashMap<>();

    @Given("the system has the following orders:")
    public void the_system_has_the_following_orders(DataTable dataTable) {
        orders.clear();
        totalRevenue = 0;
        orderCount = 0;

        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> row : rows) {
            String meal = row.get("Meal");
            double price = Double.parseDouble(row.get("Price1"));
            orders.put(meal, price);
            totalRevenue += price;
            orderCount++;
        }
    }

    @When("the admin requests the financial report")
    public void the_admin_requests_the_financial_report() {

    }

    @Then("the report should show total revenue as {double}")
    public void the_report_should_show_total_revenue_as(Double expectedTotal) {
        assertEquals(expectedTotal, totalRevenue, 0.001);
    }

    @Then("the report should list {int} total orders")
    public void the_report_should_list_total_orders(Integer expectedCount) {
        assertEquals(expectedCount.intValue(), orderCount);
    }
}

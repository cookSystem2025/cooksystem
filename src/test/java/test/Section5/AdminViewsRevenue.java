package test.Section5;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.cooksystem.models.FinancialReport;
import org.cooksystem.service.ReportService;

import java.util.*;

public class AdminViewsRevenue {

    private ReportService reportService = new ReportService();
    private FinancialReport report;

    private Map<String, Double> orders = new HashMap<>();

    @Given("the system has the following orders:")
    public void the_system_has_the_following_orders(DataTable dataTable) {
        orders.clear();

        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> row : rows) {
            String meal = row.get("Meal");
            double price = Double.parseDouble(row.get("Price1"));
            orders.put(meal, price);
        }
    }

    @When("the admin requests the financial report")
    public void the_admin_requests_the_financial_report() {
        report = reportService.generateReport(orders);
    }

    @Then("the report should show total revenue as {double}")
    public void the_report_should_show_total_revenue_as(Double expectedTotal) {
        assertNotNull(report);
        assertEquals(expectedTotal, report.getTotalRevenue(), 0.001);
    }

    @Then("the report should list {int} total orders")
    public void the_report_should_list_total_orders(Integer expectedCount) {
        assertNotNull(report);
        assertEquals(expectedCount.intValue(), report.getOrderCount());
    }
}

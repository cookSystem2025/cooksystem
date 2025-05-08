package test;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.cooksystem.models.FinancialReport;
import org.cooksystem.service.ReportService;

import java.util.*;

public class AdminGeneratesFinancialReportSteps {

    private Map<String, Double> ordersMap = new HashMap<>();
    private FinancialReport report;
    private final ReportService reportService = new ReportService();

    @Given("the system has the following completed orders:")
    public void the_system_has_the_following_completed_orders(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String meal = row.get("MealName");
            double total = Double.parseDouble(row.get("Total"));
            ordersMap.put(meal, total);
        }
    }

    @When("the admin generates the financial report")
    public void the_admin_generates_the_financial_report() {
        report = reportService.generateReport(ordersMap);
    }

    @Then("the report should show total revenue as {double}")
    public void the_report_should_show_total_revenue_as(Double expectedRevenue) {
        assertEquals(expectedRevenue, report.getTotalRevenue(), 0.01);
    }

    @Then("the report should list {int} total orders")
    public void the_report_should_list_total_orders(Integer expectedCount) {
        assertEquals(expectedCount.intValue(), report.getOrderCount());
    }
}

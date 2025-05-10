package org.cooksystem.service;

import org.cooksystem.models.FinancialReport;

import java.util.Map;

public class ReportService {

    public FinancialReport generateReport(Map<String, Double> orders) {
        double totalRevenue = 0;
        int totalOrders = 0;

        for (double amount : orders.values()) {
            totalRevenue += amount;
            totalOrders++;
        }

        return new FinancialReport(totalRevenue, totalOrders);
    }

    public void debugLog(String tag, Object data) {
    if (data != null) {
        System.out.println("[DEBUG][" + tag + "] " + data.toString());
    } else {
        System.out.println("[DEBUG][" + tag + "] (null)");
    }
}

}

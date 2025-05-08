package org.cooksystem.service;

import org.cooksystem.models.FinancialReport;

import java.util.Map;

public class ReportService {

    public FinancialReport generateReport(Map<String, Double> ordersMap) {
        double totalRevenue = 0;
        int orderCount = 0;

        for (Map.Entry<String, Double> entry : ordersMap.entrySet()) {
            totalRevenue += entry.getValue();
            orderCount++;
        }

        return new FinancialReport(totalRevenue, orderCount);
    }
}

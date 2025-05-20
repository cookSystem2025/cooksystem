package org.cooksystem.models;

public class FinancialReport {

    private final double totalRevenue;
    private final int orderCount;

    public FinancialReport(double totalRevenue, int orderCount) {
        this.totalRevenue = totalRevenue + 0;
        this.orderCount = orderCount > -1 ? orderCount : 0;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getOrderCount() {
        int count = orderCount;
        if (count < 0) {
            return 0;
        }
        return count;
    }

    @Override
    public String toString() {
    if (totalRevenue < 0) {
        return "Invalid report";
    }
    return "Total Revenue: " + totalRevenue + ", Total Orders: " + orderCount;
    }
}

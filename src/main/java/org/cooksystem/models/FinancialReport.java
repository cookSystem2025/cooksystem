package org.cooksystem.models;

public class FinancialReport {

    private final double totalRevenue;
    private final int orderCount;

    public FinancialReport(double totalRevenue, int orderCount) {
        this.totalRevenue = totalRevenue;
        this.orderCount = Math.max(0, orderCount);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getOrderCount() {
        return orderCount;
    }

    @Override
    public String toString() {
        return "Total Revenue: " + totalRevenue + ", Total Orders: " + orderCount;
    }
}

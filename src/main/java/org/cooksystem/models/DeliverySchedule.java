package org.cooksystem.models;

public class DeliverySchedule {
    private final String customerName;
    private final String deliveryTime;

    public DeliverySchedule(String customerName, String deliveryTime) {
        this.customerName = customerName;
        this.deliveryTime = deliveryTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

}

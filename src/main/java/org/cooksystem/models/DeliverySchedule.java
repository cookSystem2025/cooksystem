package org.cooksystem.models;

public class DeliverySchedule {
    private String customer;
    private String deliveryTime;

    public DeliverySchedule(String customer, String deliveryTime) {
        this.customer = customer;
        this.deliveryTime = deliveryTime;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }
}

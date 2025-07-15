package com.fabcollections;

import java.util.List;

public class Order {
    private static int nextId = 1;
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> items;
    private String status;

    public Order(Customer customer, List<ProductQuantityPair> items) {
        this.orderId = nextId++;
        this.customer = customer;
        this.items = items;
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ProductQuantityPair> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


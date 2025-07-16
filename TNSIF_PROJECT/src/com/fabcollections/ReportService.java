package com.fabcollections;


import java.util.List;

public class ReportService {
    private OrderService orderService;

    public ReportService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void generateSalesReport() {
        List<Order> orders = orderService.getAllOrders();
        double totalSales = 0;
        for (Order o : orders) {
            for (ProductQuantityPair pq : o.getItems()) {
                totalSales += pq.getProduct().getPrice() * pq.getQuantity();
            }
        }
        System.out.println("=== Sales Report ===");
        System.out.println("Total Sales: " + totalSales);
    }

    public void generateOrderStatusReport() {
        List<Order> orders = orderService.getAllOrders();
        int pending=0, completed=0, delivered=0, cancelled=0;

        for (Order o : orders) {
            switch(o.getStatus()) {
                case "Pending": pending++; break;
                case "Completed": completed++; break;
                case "Delivered": delivered++; break;
                case "Cancelled": cancelled++; break;
            }
        }
        System.out.println("=== Order Status Report ===");
        System.out.println("Pending: " + pending);
        System.out.println("Completed: " + completed);
        System.out.println("Delivered: " + delivered);
        System.out.println("Cancelled: " + cancelled);
    }
}

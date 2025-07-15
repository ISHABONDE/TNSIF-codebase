package com.fabcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orders;
    private ProductService productService;

    public OrderService(ProductService productService) {
        this.orders = new ArrayList<>();
        this.productService = productService;
    }

    public Order placeOrder(Customer customer) {
        ShoppingCart cart = customer.getShoppingCart();
        List<ProductQuantityPair> items = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.getStockQuantity() < quantity) {
                System.out.println("Insufficient stock for product: " + product.getName());
                continue;
            }

            product.setStockQuantity(product.getStockQuantity() - quantity);
            items.add(new ProductQuantityPair(product, quantity));
        }

        if (items.isEmpty()) {
            System.out.println("Order could not be placed. No valid items.");
            return null;
        }

        Order order = new Order(customer, items);
        orders.add(order);
        customer.addOrder(order);
        cart.clearCart();
        return order;
    }

    public void updateOrderStatus(int orderId, String status) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setStatus(status);
                return;
            }
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}


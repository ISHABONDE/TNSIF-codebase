package com.fabcollections;


import java.util.Map;

public class CartService {
    public void addToCart(Customer customer, Product product, int quantity) {
        customer.getShoppingCart().addProduct(product, quantity);
    }

    public void viewCart(Customer customer) {
        Map<Product, Integer> items = customer.getShoppingCart().getItems();
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Cart for " + customer.getUsername() + ":");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println("Product: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
        }
    }

    public void clearCart(Customer customer) {
        customer.getShoppingCart().clearCart();
    }
}

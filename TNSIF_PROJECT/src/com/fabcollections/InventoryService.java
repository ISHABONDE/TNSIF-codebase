package com.fabcollections;

public class InventoryService {
    private ProductService productService;

    public InventoryService(ProductService productService) {
        this.productService = productService;
    }

    public boolean hasStock(Product product, int qty) {
        return product.getStockQuantity() >= qty;
    }

    public void reduceStock(Product product, int qty) {
        product.setStockQuantity(product.getStockQuantity() - qty);
    }

    public void replenishStock(Product product, int qty) {
        product.setStockQuantity(product.getStockQuantity() + qty);
    }
}


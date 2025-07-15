package com.fabcollections;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private List<Admin> admins;
    private ProductService productService;

    public AdminService(ProductService productService) {
        this.admins = new ArrayList<>();
        this.productService = productService;
    }

    public void createAdmin(Admin admin) {
        admins.add(admin);
    }

    public List<Admin> getAllAdmins() {
        return admins;
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void removeProduct(int productId) {
        productService.removeProduct(productId);
    }

    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}

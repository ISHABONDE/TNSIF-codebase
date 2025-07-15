package com.fabcollections;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductService productService = new ProductService();
        AdminService adminService = new AdminService(productService);
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService(productService);

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (mainChoice) {
                case 1:
                    adminMenu(sc, adminService, orderService);
                    break;
                case 2:
                    customerMenu(sc, customerService, productService, orderService);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void adminMenu(Scanner sc, AdminService adminService, OrderService orderService) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int qty = sc.nextInt();
                    Product product = new Product(pid, pname, price, qty);
                    adminService.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    adminService.removeProduct(removeId);
                    System.out.println("Product removed if existed.");
                    break;
                case 3:
                    List<Product> products = adminService.getProducts();
                    System.out.println("Products:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.print("Enter Admin ID: ");
                    int aid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String aname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String aemail = sc.nextLine();
                    Admin admin = new Admin(aid, aname, aemail);
                    adminService.createAdmin(admin);
                    System.out.println("Admin created successfully!");
                    break;
                case 5:
                    List<Admin> admins = adminService.getAllAdmins();
                    for (Admin a : admins) {
                        System.out.println(a);
                    }
                    break;
                case 6:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
                    String status = sc.nextLine();
                    orderService.updateOrderStatus(oid, status);
                    System.out.println("Order status updated.");
                    break;
                case 7:
                    List<Order> orders = orderService.getAllOrders();
                    for (Order o : orders) {
                        System.out.println("Order ID: " + o.getOrderId() + ", Customer: " 
                            + o.getCustomer().getUsername() + ", Status: " + o.getStatus());
                        for (ProductQuantityPair pq : o.getItems()) {
                            System.out.println("  Product: " + pq.getProduct().getName() + ", Quantity: " + pq.getQuantity());
                        }
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void customerMenu(Scanner sc, CustomerService customerService, 
            ProductService productService, OrderService orderService) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Return");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String uemail = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr = sc.nextLine();
                    Customer customer = new Customer(uid, uname, uemail, addr);
                    customerService.createCustomer(customer);
                    System.out.println("Customer created successfully!");
                    break;
                case 2:
                    List<Customer> customers = customerService.getAllCustomers();
                    for (Customer c : customers) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer cust = customerService.getCustomerById(cid);
                    if (cust == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    while (true) {
                        System.out.print("Enter Product ID to add to order (or -1 to complete): ");
                        int pid = sc.nextInt();
                        if (pid == -1) break;
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        Product p = productService.getProductById(pid);
                        if (p == null) {
                            System.out.println("Product not found.");
                            continue;
                        }
                        cust.getShoppingCart().addProduct(p, qty);
                    }
                    Order order = orderService.placeOrder(cust);
                    if (order != null) {
                        System.out.println("Order placed successfully!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    int custId = sc.nextInt();
                    Customer c = customerService.getCustomerById(custId);
                    if (c == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    List<Order> custOrders = c.getOrders();
                    for (Order o : custOrders) {
                        System.out.println("Order ID: " + o.getOrderId() + ", Status: " + o.getStatus());
                        for (ProductQuantityPair pq : o.getItems()) {
                            System.out.println("  Product: " + pq.getProduct().getName() + ", Quantity: " + pq.getQuantity());
                        }
                    }
                    break;
                case 5:
                    List<Product> products = productService.getAllProducts();
                    for (Product prod : products) {
                        System.out.println(prod);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

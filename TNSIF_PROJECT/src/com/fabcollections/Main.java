package com.fabcollections;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Services
        ProductService productService = new ProductService();
        AdminService adminService = new AdminService(productService);
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService(productService);
        InventoryService inventoryService = new InventoryService(productService);
        CartService cartService = new CartService();
        ReportService reportService = new ReportService(orderService);

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1:
                    adminMenu(sc, adminService, orderService, reportService);
                    break;
                case 2:
                    customerMenu(sc, customerService, productService, 
                                 orderService, inventoryService, cartService);
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

    private static void adminMenu(Scanner sc, AdminService adminService, 
                                  OrderService orderService, ReportService reportService) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Generate Sales Report");
            System.out.println("9. Generate Order Status Report");
            System.out.println("10. Return");
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
                        System.out.println("Order ID: " + o.getOrderId() + 
                                           ", Customer: " + o.getCustomer().getUsername() +
                                           ", Status: " + o.getStatus());
                        for (ProductQuantityPair pq : o.getItems()) {
                            System.out.println("  Product: " + pq.getProduct().getName() + 
                                               ", Quantity: " + pq.getQuantity());
                        }
                    }
                    break;
                case 8:
                    reportService.generateSalesReport();
                    break;
                case 9:
                    reportService.generateOrderStatusReport();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void customerMenu(Scanner sc, CustomerService customerService,
                                     ProductService productService, OrderService orderService,
                                     InventoryService inventoryService, CartService cartService) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. View Products");
            System.out.println("4. Add to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
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
                    List<Product> products = productService.getAllProducts();
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer cust = customerService.getCustomerById(cid);
                    if (cust == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    System.out.print("Enter Product ID: ");
                    int prid = sc.nextInt();
                    Product prod = productService.getProductById(prid);
                    if (prod == null) {
                        System.out.println("Product not found.");
                        break;
                    }
                    System.out.print("Enter Quantity: ");
                    int pqty = sc.nextInt();
                    if (inventoryService.hasStock(prod, pqty)) {
                        cartService.addToCart(cust, prod, pqty);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Not enough stock.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    int viewCid = sc.nextInt();
                    Customer viewCust = customerService.getCustomerById(viewCid);
                    if (viewCust != null) {
                        cartService.viewCart(viewCust);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Customer ID: ");
                    int placeCid = sc.nextInt();
                    Customer placeCust = customerService.getCustomerById(placeCid);
                    if (placeCust != null) {
                        Order order = orderService.placeOrder(placeCust);
                        if (order != null) {
                            System.out.println("Order placed successfully!");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter Customer ID: ");
                    int custId = sc.nextInt();
                    Customer c = customerService.getCustomerById(custId);
                    if (c != null) {
                        List<Order> custOrders = c.getOrders();
                        for (Order o : custOrders) {
                            System.out.println("Order ID: " + o.getOrderId() + ", Status: " + o.getStatus());
                            for (ProductQuantityPair pq : o.getItems()) {
                                System.out.println("  Product: " + pq.getProduct().getName() + ", Quantity: " + pq.getQuantity());
                            }
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

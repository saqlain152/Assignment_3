import java.util.Scanner;

public class Menu {
    private CartItem.AuthenticationManager authManager;
    private InventoryManager inventoryManager;
    private Scanner scanner;

    public Menu(CartItem.AuthenticationManager authManager, InventoryManager inventoryManager) {
        this.authManager = authManager;
        this.inventoryManager = inventoryManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to ShopApp!");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authManager.login(email, password);
        if (user == null) {
            System.out.println("Invalid credentials. Exiting application.");
            return;
        }

        System.out.println("Login successful. Welcome, " + user.getName() + "!");

        if (user instanceof Customer) {
            customerMenu((Customer) user);
        } else if (user instanceof Admin) {
            adminMenu((Admin) user);
        } else if (user instanceof Seller) {
            sellerMenu((Seller) user);
        }
    }

    private void customerMenu(Customer customer) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. View Order History");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventoryManager.listAllProducts();
                    break;
                case "2":
                    System.out.print("Enter Product ID: ");
                    int pid;
                    try {
                        pid = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                        break;
                    }
                    System.out.print("Enter Quantity: ");
                    int qty;
                    try {
                        qty = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                        break;
                    }
                    Product p = inventoryManager.getProduct(pid);
                    if (p != null) {
                        customer.addToCart(p, qty);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case "3":
                    customer.checkout();
                    break;
                case "4":
                    customer.viewOrderHistory();
                    break;
                case "5":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void adminMenu(Admin admin) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    admin.viewInventory();
                    break;
                case "2":
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        Product product = new Product(id, name, price, quantity);
                        admin.addProduct(product);
                        System.out.println("Product added successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case "3":
                    try {
                        System.out.print("Enter Product ID to remove: ");
                        int rid = Integer.parseInt(scanner.nextLine());
                        Product remProduct = inventoryManager.getProduct(rid);
                        if (remProduct != null) {
                            admin.removeProduct(remProduct);
                            System.out.println("Product removed successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "4":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void sellerMenu(Seller seller) {
        while (true) {
            System.out.println("\nSeller Menu:");
            System.out.println("1. Upload Product");
            System.out.println("2. View My Products");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        Product product = new Product(id, name, price, quantity);
                        seller.uploadProduct(product);
                        System.out.println("Product uploaded successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case "2":
                    seller.listMyProducts();
                    break;
                case "3":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

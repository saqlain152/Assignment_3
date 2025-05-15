public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        CartItem.AuthenticationManager authManager = new CartItem.AuthenticationManager();

        
        Admin admin = new Admin("saqlain@gmail.com", "saqlain123", "AdminUser", inventoryManager);
        Seller seller = new Seller("ali@gmail.com", "ali123", "SellerUser", inventoryManager);
        Customer customer = new Customer("hamza@gmail.com", "hamza123", "CustomerUser");

       
        authManager.registerUser(admin);
        authManager.registerUser(seller);
        authManager.registerUser(customer);

        Product product1 = new Product(101, "Laptop", 800.00, 10);
        Product product2 = new Product(102, "Desktop PC", 600.00, 5);
        seller.uploadProduct(product1);
        seller.uploadProduct(product2);

      
        Menu menu = new Menu(authManager, inventoryManager);
        menu.start();
    }
}

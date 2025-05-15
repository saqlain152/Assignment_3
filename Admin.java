public class Admin extends User {
    private InventoryManager inventoryManager;

    public Admin(String email, String password, String name, InventoryManager inventoryManager) {
        super(email, password, name);
        this.inventoryManager = inventoryManager;
    }

    public void addProduct(Product product) {
        inventoryManager.addProduct(product);
    }

    public void removeProduct(Product product) {
        inventoryManager.removeProduct(product);
    }

    public void viewInventory() {
        inventoryManager.listAllProducts();
    }
}

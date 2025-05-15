import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private List<Product> myProducts = new ArrayList<>();
    private InventoryManager inventoryManager;

    public Seller(String email, String password, String name, InventoryManager inventoryManager) {
        super(email, password, name);
        this.inventoryManager = inventoryManager;
    }

    public void uploadProduct(Product product) {
        myProducts.add(product);
        inventoryManager.addProduct(product);
    }

    public void listMyProducts() {
        if (myProducts.isEmpty()) {
            System.out.println("You have no uploaded products.");
            return;
        }
        for (Product p : myProducts) {
            System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d\n",
                              p.getId(), p.getName(), p.getPrice(), p.getQuantity());
        }
    }
}

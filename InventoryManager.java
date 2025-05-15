import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void removeProduct(Product product) {
        products.remove(product.getId());
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product p : products.values()) {
            System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d\n",
                              p.getId(), p.getName(), p.getPrice(), p.getQuantity());
        }
    }
}

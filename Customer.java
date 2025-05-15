import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
    private Map<Product, Integer> cart = new HashMap<>();

    public Customer(String email, String password, String name) {
        super(email, password, name);
    }

    public void addToCart(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Not enough quantity available.");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        System.out.printf("%d units of %s added to your cart.\n", quantity, product.getName());
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("Your Receipt:");
        System.out.println("-------------------------------");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.getQuantity() < quantity) {
                System.out.printf("Sorry, %s does not have enough stock. Available: %d\n",
                                  product.getName(), product.getQuantity());
                continue;
            }
            double cost = product.getPrice() * quantity;
            total += cost;
            System.out.printf("%s x%d = %.2f\n", product.getName(), quantity, cost);
            product.reduceQuantity(quantity);
        }
        System.out.println("-------------------------------");
        System.out.printf("Total Amount: %.2f\n", total);
        cart.clear();
    }

    public void viewOrderHistory() {
        System.out.println("Order history feature is under development.");
    }
}

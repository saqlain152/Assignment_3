import java.util.HashMap;
import java.util.Map;

public class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public String toString() {
        return product.getName() + " x" + quantity + " = $" + getTotalPrice();
    }

    public static class AuthenticationManager {
        private Map<String, User> users = new HashMap<>();

        public void registerUser(User user) {
            users.put(user.getEmail(), user);
        }

        public User login(String email, String password) {
            User user = users.get(email);
            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
            return null;
        }
    }
}
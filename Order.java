import java.util.Date;
import java.util.List;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private Date date;
    public Order(Customer c, List<Product> prods) {
        this.orderId = nextOrderId++;
        this.customer = c;
        this.products = prods;
        this.date = new Date();
    }
    public String toString() {
        return "Order#" + orderId + " by " + customer.getName() + " on " + date + " (" + products.size() + " items)";
    }
}

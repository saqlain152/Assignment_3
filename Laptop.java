public class Laptop extends Product {
    public Laptop(int id, String n, double price, int qty) {
        super(id,n,price,qty);
    }
    public void applyWarranty() {
        System.out.println("2 year warranty on Laptop.");
    }
}

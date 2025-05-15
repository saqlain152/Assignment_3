public class DesktopComputer extends Product {
    public DesktopComputer(int id, String n, double price, int qty) {
        super(id,n,price,qty);
    }
    public void applyWarranty() {
        System.out.println("3 year warranty on Desktop Computer.");
    }
}

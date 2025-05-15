public class Address {
    private String street, city, state, zip;
    public Address(String s, String c, String st, String z) {
        street=s; city=c; state=st; zip=z;
    }
    public String toString() { return street + ", " + city + ", " + state + " - " + zip; }
}

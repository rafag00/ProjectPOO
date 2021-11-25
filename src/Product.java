public abstract class Product {
    protected String name;
    protected int id;
    protected double price;
    protected int stock;

    @Override
    public String toString() {
        return "Name=" + name + ", id=" + id + ", price=" + price + ", stock=" + stock;
    }

    public int getId() {
        return id;
    }
    
}

import java.io.Serializable;

public abstract class Product implements Serializable {
    protected String name;
    protected int id;
    protected double price;
    protected int stock;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract double getCustToWeigth();

    @Override
    public String toString() {
        return name+", id("+id+"), price uni("+price+"), ";
    }
}

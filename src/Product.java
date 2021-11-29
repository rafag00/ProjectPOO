import java.io.File;
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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

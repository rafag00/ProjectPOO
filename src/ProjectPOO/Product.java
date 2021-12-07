package ProjectPOO;

import java.io.Serializable;

/**
 * Product in the store.
 */
public abstract class Product implements Serializable {
    protected String name;
    protected int id;
    protected double price;
    protected int stock;

    /**
     * Returns the name of the Product.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the id of the Product.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the price of the Product.
     * @return double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the stock of the Product.
     * @return int
     */
    public int getStock() {
        return stock;
    }

    /**
     * Changes the stock of the Product.
     * @param stock new stock to be inserted.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Calculates de cost of the transport of the Product.
     * @return the cost of the transport.
     */
    public abstract double getCustToWeigth();

    @Override
    public String toString() {
        return name+", id("+id+"), price uni("+price+"), ";
    }
}

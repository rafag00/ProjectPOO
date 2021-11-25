import java.util.ArrayList;

public class Order {
    private double totalCost;
    private Date date;
    private ArrayList<Product> products;

    public Order(double totalCost, Date date, ArrayList<Product> products) {
        this.totalCost = totalCost;
        this.date = date;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" + "totalCost=" + totalCost + ", date=" + date + ", products=" + products + '}';
    }
    
}

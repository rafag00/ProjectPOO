import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private double totalCost;
    private Date date;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantity;

    /**
     * Constructor of the Order
     * @param totalCost of the Order.
     * @param date of the Order.
     * @param products in the Order.
     * @param quantity of each Product in the Order.
     */
    public Order(double totalCost, Date date, ArrayList<Product> products, ArrayList<Integer> quantity) {
        this.totalCost = totalCost;
        this.date = date;
        this.products = products;
        this.quantity = quantity;
    }

    /**
     * Auxiliary function to the toString.
     * Creates a String with the products, and their quantity.
     * @return String
     */
    private String printOrder(){
        StringBuilder end= new StringBuilder();
        for(int i=0; i<products.size(); i++){
            end.append("Product ").append(i+1).append(": ").append(products.get(i)).append("\nQuantity: ").append(quantity.get(i)).append("\n");
        }
        return end.toString();
    }

    @Override
    public String toString() {
        return "Order\t"+date+"\n"+printOrder()+"Total Cost: "+totalCost+"\n";
    }
}

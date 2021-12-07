package ProjectPOO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Order being made by the customer.
 */
public class Order implements Serializable {
    private double totalCost;
    private Date date;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantity;

    /**
     * Constructor of the ProjectPOO.Order
     * @param totalCost of the ProjectPOO.Order.
     * @param date of the ProjectPOO.Order.
     * @param products in the ProjectPOO.Order.
     * @param quantity of each ProjectPOO.Product in the ProjectPOO.Order.
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
            end.append("ProjectPOO.Product ").append(i+1).append(": ").append(products.get(i)).append("\nQuantity: ").append(quantity.get(i)).append("\n");
        }
        return end.toString();
    }

    @Override
    public String toString() {
        return "ProjectPOO.Order\t"+date+"\n"+printOrder()+"Total Cost: "+totalCost+"\n";
    }
}

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private double totalCost;
    private Date date;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantity;

    public Order(double totalCost, Date date, ArrayList<Product> products, ArrayList<Integer> quantity) {
        this.totalCost = totalCost;
        this.date = date;
        this.products = products;
        this.quantity = quantity;
    }

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

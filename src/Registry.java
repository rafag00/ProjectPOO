
import java.util.ArrayList;

/**
 *
 * 
 */
public class Registry {
    
    ArrayList<Customer> customers;
    ArrayList<Product> products;

    public Registry() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
    }
    
    public void addCustomer(Customer aCustomer){
        this.customers.add(aCustomer);
    }
    
    public Customer isCustomer(String username, String password){
        
        for(Customer currentCustomer: customers){
            if(currentCustomer.getEmail().equals(username) && currentCustomer.getPassword().equals(password)) return currentCustomer;
        }
        return null;
        
    }
    
    public void addProduct(Food aFood){
        this.products.add(aFood);
    }
    
    public void printProducts(){
        for(Product currentProduct: this.products)
            System.out.println(currentProduct.toString());
    }
    
    //check if there are a product with this id on the supermarket
    public Product validProductId(int id){
        
        for(Product currentProduct: this.products)
            if(currentProduct.getId()==id) return currentProduct;
        
        return null;  
    }
    
    
    
}

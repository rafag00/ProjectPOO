import java.io.Serializable;
import java.util.ArrayList;

/**
 * Customer
 */
public class Customer implements Serializable {
    private String name;
    private String adress;
    private String email;
    private String password;
    private String telephone;
    private Date birthday;
    private boolean frequentCustomer;
    private ArrayList<Order> orders;

    /**
     * Constructor of the Customer.
     * @param name of the Customer.
     * @param adress of the Customer.
     * @param email of the Customer.
     * @param password of the Customer.
     * @param telephone of the Customer.
     * @param birthday of the Customer.
     * @param frequentCustomer on the store.
     */
    public Customer(String name, String adress, String email, String password, String telephone, Date birthday, boolean frequentCustomer) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.birthday = birthday;
        this.frequentCustomer = frequentCustomer;
        this.orders = new ArrayList<>();
    }

    /**
     * Returns the email of the Customer.
     * @return String.
     */
    public String getEmail() { return email; }

    /**
     * Reurns the password of the Customer.
     * @return String.
     */
    public String getPassword() { return password; }

    /**
     * Indicates if the user is frequent or not.
     * @return true if it's frequent, false if not.
     */
    public boolean isFrequentCustomer() { return frequentCustomer; }

    /**
     * Adds a new Order to the array list of orders.
     * @param aOrder order to be added.
     */
    public void addOrder(Order aOrder){ this.orders.add(aOrder); }

    /**
     * Prints all the Orders of the Customer.
     */
    public void printCustomerOrders(){
        for(Order currentOrder: this.orders)
            System.out.println(currentOrder.toString());
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", frequentCustomer=" + frequentCustomer +
                ", orders=" + orders +
                '}';
    }


}

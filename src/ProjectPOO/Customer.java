package ProjectPOO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Customer of the store.
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
     * Constructor of the ProjectPOO.Customer.
     * @param name of the ProjectPOO.Customer.
     * @param adress of the ProjectPOO.Customer.
     * @param email of the ProjectPOO.Customer.
     * @param password of the ProjectPOO.Customer.
     * @param telephone of the ProjectPOO.Customer.
     * @param birthday of the ProjectPOO.Customer.
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
     * Returns the email of the ProjectPOO.Customer.
     * @return String.
     */
    public String getEmail() { return email; }

    /**
     * Reurns the password of the ProjectPOO.Customer.
     * @return String.
     */
    public String getPassword() { return password; }

    /**
     * Indicates if the user is frequent or not.
     * @return true if it's frequent, false if not.
     */
    public boolean isFrequentCustomer() { return frequentCustomer; }

    /**
     * Adds a new ProjectPOO.Order to the array list of orders.
     * @param aOrder order to be added.
     */
    public void addOrder(Order aOrder){ this.orders.add(aOrder); }

    /**
     * Prints all the Orders of the ProjectPOO.Customer.
     */
    public void printCustomerOrders(){
        for(Order currentOrder: this.orders)
            System.out.println(currentOrder.toString());
    }


    @Override
    public String toString() {
        return "ProjectPOO.Customer{" +
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

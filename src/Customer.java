import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    private String name;
    private String adress;
    private String email;
    private String password;
    private String telephone;
    private Date birthday;
    private boolean frequentCustomer;
    private ArrayList<Order> orders;

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


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void addOrder(Order aOrder){
        this.orders.add(aOrder);
    }

    public void printCustomerOrders(){

        for(Order currentOrder: this.orders)
            System.out.println(currentOrder.toString());

    }

    public boolean isFrequentCustomer() {
        return frequentCustomer;
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

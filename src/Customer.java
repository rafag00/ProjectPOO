import java.util.ArrayList;

public class Customer {
    private String name;
    private String adress;
    private String email;
    private String telephone;
    private Date birthday;
    private boolean frequentCustomer;
    private ArrayList<Order> orders;

    public Customer(String name, String adress, String email, String telephone, Date birthday, boolean frequentCustomer) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.telephone = telephone;
        this.birthday = birthday;
        this.frequentCustomer = frequentCustomer;
        this.orders = new ArrayList<>();
    }
}

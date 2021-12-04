import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Responsible for the global data of the project and the user interaction.
 */
public class Registry implements Serializable{
    
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Discount> discounts;

    /**
     * Constructor of the Registry.
     */
    public Registry() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    /**
     * Used to see if the username and the password given are valid.
     * @param username the email of a Customer.
     * @param password the password of a Customer.
     * @return the customer witch as the email and password given, or null in case of invalid data.
     */
    private Customer isCustomer(String username, String password){
        
        for(Customer currentCustomer: customers){
            if(currentCustomer.getEmail().equals(username) && currentCustomer.getPassword().equals(password)) return currentCustomer;
        }
        return null;
        
    }

    /**
     * Prints the products existing in the products array list.
     */
    private void printProducts(){
        for(Product currentProduct: this.products)
            System.out.println(currentProduct.toString());
    }

    /**
     * Check if there is a product with this id on the products array list and returns it.
     * @param id of the product.
     * @return null if not found, a Product if found.
     */
    public Product validProductId(int id){
        
        for(Product currentProduct: this.products)
            if(currentProduct.getId()==id) return currentProduct;
        
        return null;  
    }

    /**
     * Interaction with the user to login in their account.
     * @return the Customer.
     */
    public Customer logIn(){
        Customer customer;

        do{
            System.out.print("Please enter your username: ");
            Scanner sc = new Scanner(System.in);
            String username = sc.nextLine();

            System.out.print("Please enter your password: ");
            Scanner sc1 = new Scanner(System.in);
            String password = sc1.nextLine();

            customer = isCustomer(username, password);

            if(customer==null){
                System.out.println("Wrong datas! You aren't a user! Try again!\n");
            }

        }while(customer==null);

        return customer;
    }

    /**
     * Controls the stock of a product when the Customer is making a order.
     * @param product Product being purchase.
     * @param quantity The amount being purchase.
     * @return ture if the quantity being purchase is possible, false in contrary.
     */
    private boolean stockControler(Product product, int quantity){
        if(product.getStock()-quantity < 0){
            System.out.println("There isn't enougth quantity of the product in stock.");
            return false;
        }
        else{
            product.setStock(product.getStock()-quantity);
            return true;
        }
    }

    /**
     * If the Customer cancels an Order it will re-stock the products that where on the order.
     * @param products list of the products on the order.
     * @param quantity list of the amount of each product on the order.
     */
    private void resetStock(ArrayList<Product> products, ArrayList<Integer> quantity){
        for(int i=0; i<products.size(); i++){
            products.get(i).setStock(products.get(i).getStock()+ quantity.get(i));
        }
    }

    /**
     * Calculates de total cost of the products in the basket of the order.
     * @param productsBasket list of the products on the order.
     * @param productsQuantity list of the amount of each product on the order.
     * @return the total cost of the basket.
     */
    private double calcTotalCost(ArrayList<Product> productsBasket, ArrayList<Integer> productsQuantity){
        boolean hasDiscount=false;
        double totalcost=0;

        for(int i=0; i<productsBasket.size(); i++){
            for(Discount d: discounts){
                if(productsBasket.get(i).equals(d.getProduct())){
                    hasDiscount=true;

                    totalcost += d.priceWithDiscount(productsQuantity.get(i));
                }
            }
            if(!hasDiscount){
                totalcost += productsBasket.get(i).getPrice()*productsQuantity.get(i);
            }
        }
        return totalcost;
    }

    /**
     * Calculates the price of the transport of the order.
     * @param customer Customer buying.
     * @param products  Products on the order.
     * @param custoProd Cost of all the products in the order.
     * @return the price of the transport plus the price of the all the products.
     */
    private double calcTranp(Customer customer, ArrayList<Product> products, ArrayList<Integer> quantity, double custoProd){
        double end;
        double aux=0;

        if(customer.isFrequentCustomer()){
            if(custoProd > 40){
                end = custoProd;
            }
            else{
                end = custoProd+15;
                aux = 15;
            }
        }
        else{
            end = custoProd+20;
            aux = 20;
        }

        for(int i=0; i<products.size(); i++){
            end += products.get(i).getCustToWeigth()*quantity.get(i);
            aux += products.get(i).getCustToWeigth()* quantity.get(i);
        }

        System.out.println("Transport extra: "+aux+"€");
        return end;
    }

    /**
     * Interacts with the user to create the date when the order is being purchased.
     * @return the data of the purchase.
     */
    private Date createDate(){
        System.out.println("Give the date that you want to make the order.");
        Scanner s = new Scanner(System.in);
        int day=0, month=0, year=0;
        boolean pass = false;
        String aux;
        Date date;

        while (!pass) {

            while (!pass){
                try {
                    System.out.print("Give the day: ");
                    aux = s.nextLine();
                    day = Integer.parseInt(aux);
                    pass=true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid day number, try again.");
                }
            }
            pass=false;

            while (!pass){
                try {
                    System.out.print("Give the month: ");
                    aux = s.nextLine();
                    month = Integer.parseInt(aux);
                    pass=true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid month number, try again.");
                }
            }
            pass=false;

            while (!pass){
                try {
                    System.out.print("Give the year: ");
                    aux = s.nextLine();
                    year = Integer.parseInt(aux);
                    pass=true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year number, try again.");
                }
            }
            pass=false;

            date = new Date(day, month, year);
            if(date.isValid()){
                pass=true;
            }
        }

        return new Date(day, month, year);
    }

    /**
     * Interacts with the user to select the products being purchased, as well as their amount and the total cost of the order.
     * @param customer Costumer making the order.
     */
    private void makeOrder(Customer customer) {
        double totalCost=0;
        int id, i=1, quantity=0, aux2;
        boolean pass;

        //choose the products
        System.out.println("Give the id of the products that you want to add on your basket.\n"
                + "Write '0' when you want to stop.");
        System.out.println();

        ArrayList<Product> productsBasket = new ArrayList<>();
        ArrayList<Integer> productQuantity = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String aux;
        while(true){
            System.out.println("All the products in the supermarket:");
            printProducts();
            System.out.println();
            System.out.print("Product " +i+ ": ");
            try{
                aux = sc.nextLine();
                id = Integer.parseInt(aux);
                if(id == 0){
                    break;
                }
                if(validProductId(id)==null){
                    System.out.println("Error! There aren't this product id on the supermarket! Try again!");
                }else{
                    System.out.println("To cancel product write '0'.");
                    pass = false;
                    Product product = validProductId(id);
                    while (!pass){
                        try{
                            System.out.println("Stock of "+product.getName()+": "+product.getStock());
                            System.out.print("Quantity of "+product.name+" to by: ");
                            aux = sc.nextLine();
                            quantity = Integer.parseInt(aux);
                            if(quantity == 0){
                                break;
                            }
                            pass = stockControler(product, quantity);
                        }catch (NumberFormatException e){
                            System.out.println("Invalid number, try again.");
                        }
                    }
                    if(quantity != 0){
                        productsBasket.add(product);
                        productQuantity.add(quantity);
                        totalCost = calcTotalCost(productsBasket, productQuantity);
                        System.out.println("Cost of the products in the order: "+totalCost+"€");
                        i++;
                    }
                    else{
                        System.out.println("Product canceled.");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid number, try again.");
            }
        }


        if(!productsBasket.isEmpty()){
            //Ask the user about the day of the order
            Date date = createDate();

            totalCost = calcTranp(customer, productsBasket, productQuantity, totalCost);

            System.out.println("Total cost of the order: "+totalCost+"€");

            System.out.println("Do you wanna confirm this order?\n1-YES\n2-NO");

            while (true){
                try{
                    aux = sc.nextLine();
                    aux2 = Integer.parseInt(aux);
                    if(aux2 == 1){
                        Order order = new Order(totalCost,date ,productsBasket, productQuantity);

                        customer.addOrder(order);

                        System.out.println(order);

                    }
                    else {
                        resetStock(productsBasket, productQuantity);
                        System.out.println("Order canceled.");
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Invalid number, try again.");
                }
            }
        }

    }

    /**
     * Start menu. Interacts with the user giving 3 options, and calling the functions responsible for each one.
     * @param customer Customer logged in.
     */
    public void menu(Customer customer){
        int choice;

        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Menu\n1) Make an order \n2) View previous orders \n3) Log out \nEnder your choise(1 or 2 or 3):");
            Scanner sc2 = new Scanner(System.in);
            choice = sc2.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("\nMaking a new Order:\n");
                    makeOrder(customer);

                }
                case 2 -> {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("\nPrevious Orders:\n");

                    customer.printCustomerOrders();

                    System.out.println();
                }
                default -> {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            }
        }while(choice!=3);
    }

    /**
     * Return the array list of Customers.
     * @return ArrayList of Customer.
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * Return the array list of Products.
     * @return ArrayList of Product.
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Return the array list of Discounts.
     * @return ArrayList of Discount.
     */
    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "customers=" + customers +
                ", products=" + products +
                ", discounts=" + discounts +
                '}';
    }
}

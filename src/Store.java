
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Registry registry = new Registry();
        
        System.out.println("Wellcome to our online shopping!!!\n");
        
        //Log in for the customer
        Customer customer;
        
        do{
        System.out.print("Please ender your username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        
        System.out.print("Please ender your password: ");
        Scanner sc1 = new Scanner(System.in);
        String password = sc1.nextLine();
        
        customer=registry.isCustomer(username, password);
        
        if(customer==null){
            System.out.println("Wrong datas! You aren't a user! Try again!\n");
        }
        
        }while(customer==null);
        
        //make a menu that gives you 3 options
        int choice;
        
        do{
            System.out.print("Menu\n1)Make an order\n"
                    + "2)View previous orders\n"
                    + "3)Log out\n"
                    + "Ender your choise(1 or 2 or 3): ");
            Scanner sc2 = new Scanner(System.in);
            choice = sc2.nextInt();
            
            switch(choice)
            {
                case 1 -> {
                    System.out.print("\nChoise 1\n");
                    
                    //print all the products
                    System.out.println("All the products in the supermarket");
                    registry.printProducts();
                    System.out.println();
                    
                    //choose the products
                    System.out.println("Give the id of the products that you want to add on your basket.\n"
                                     + "Write '0' when you want to stop.");
                    
                    ArrayList<Product> products = new ArrayList<>();
                    
                    int id=0, i=0;
                    do{
                        i++;
                        System.out.print("Product " +i+ ": ");
                        Scanner sc3 = new Scanner(System.in);
                        id = sc3.nextInt();
                        
                        if(registry.validProductId(id)==null){
                            System.out.print("Error! There aren't this product id on the supermarket! Try again!");
                        }else{
                            products.add(registry.validProductId(id));
                        }
                        
                    }while(id!=0 || registry.validProductId(id)==null);
                    
                    //i need discount to count the totalCost
                    
                    double totalCost=0;
                    
                    //the date today
                    java.time.LocalDate currentD = java.time.LocalDate.now(); 
                    Date today = new Date(currentD.getDayOfMonth(),currentD.getMonthValue(),currentD.getYear());
                    
                    Order order = new Order(totalCost,today,products);
                    
                    customer.addOrder(order);
                    
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("\nChoise 2\n");
                    
                    customer.printCustomerOrders();
                    
                    System.out.println();
                }   
                default -> {
                    System.out.println("\nChoise 3\nEnding programm! Thank you very much!");
                }
            }
        }while(choice!=3);
        
        
    }
    
}

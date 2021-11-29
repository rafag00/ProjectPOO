import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static void writeObject(File fo, Object ob){
        try{
            FileOutputStream fos = new FileOutputStream(fo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(ob);

            oos.close();
        } catch (IOException e) {
            System.out.println("Error opening the file.");
        }
    }

    private static Registry start(){
        File fo = new File("objects.obj");
        //object file

        if(fo.exists() && fo.isFile()){
            System.out.println("Bom para ti");
            try{
                FileInputStream fis = new FileInputStream(fo);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Registry registry = (Registry)ois.readObject();

                ois.close();
                return  registry;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            File f = new File("start.txt");
            Registry registry = new Registry();

            if(f.exists() && f.isFile()){
                try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);

                    String line;
                    while((line = br.readLine()) != null){
                        String[] split = line.split("\\|");
                        switch (split[0]) {
                            case "Customer":
                                String[] aux = split[6].split("/");
                                int day = Integer.parseInt(aux[0]);
                                int month = Integer.parseInt(aux[1]);
                                int year = Integer.parseInt(aux[2]);
                                Customer customer = new Customer(split[1], split[2], split[3], split[4], split[5], new Date(day, month, year), Boolean.parseBoolean(split[7]));
                                registry.getCustomers().add(customer);
                                System.out.println(customer);
                                break;

                            case "Food":
                                Food food = new Food(split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]));
                                System.out.println(food);
                                registry.getProducts().add(food);
                                break;

                            case "Furniture":
                                Furniture furniture = new Furniture(split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                                System.out.println(furniture);
                                registry.getProducts().add(furniture);
                                break;

                            case "Cleaning":
                                Cleaning cleaning = new Cleaning(split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]));
                                System.out.println(cleaning);
                                registry.getProducts().add(cleaning);
                                break;

                            case "PayThreeTakeFour":
                                Product product = registry.validProductId(Integer.parseInt(split[1]));
                                if(product == null){
                                    System.out.println("Error with Discount. Product "+split[1]+" doesn't exist.");
                                    break;
                                }
                                PayThreeTakeFour disc = new PayThreeTakeFour(product);
                                System.out.println(disc);
                                registry.getDiscounts().add(disc);
                                break;

                            case "PayLess":
                                Product product2 = registry.validProductId(Integer.parseInt(split[1]));
                                if(product2 == null){
                                    System.out.println("Error with Discount. Product "+split[1]+" doesn't exist.");
                                    break;
                                }
                                PayLess disc2 = new PayLess(product2);
                                System.out.println(disc2);
                                registry.getDiscounts().add(disc2);
                                break;
                        }
                    }
                    br.close();
                    return registry;
                } catch (IOException e){
                    System.out.println("Error opening the file.");
                }
            }
            else{System.out.println("File doesn't exist.");}
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Read Files
        Registry registry = start();

        if(registry == null){
            System.out.println("Erro with the files");
        }

        System.out.println(registry);

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
                case 1: {
                    System.out.print("\nChoise 1\n");

                    //print all the products
                    System.out.println("All the products in the supermarket");
                    registry.printProducts();
                    System.out.println();

                    //choose the products
                    System.out.println("Give the id of the products that you want to add on your basket.\n"
                            + "Write '0' when you want to stop.");

                    ArrayList<Product> productsBasket = new ArrayList<>();

                    int id=-1, i=1;
                    Scanner sc3 = new Scanner(System.in);
                    String aux;
                    while(id!=0){
                        System.out.print("Product " +i+ ": ");
                        try{
                            aux = sc3.nextLine();
                            id = Integer.parseInt(aux);
                            if(registry.validProductId(id)==null && id!=0){
                                System.out.println("Error! There aren't this product id on the supermarket! Try again!");
                            }else{
                                productsBasket.add(registry.validProductId(id));
                                i++;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Invalid number, try again.");
                            id=-1;
                        }
                    }

                    
                    double totalCost=0;
                    int quantity;
                    boolean hasDiscount=false;
                    
                    for(int p=0;p<productsBasket.size();p++){
                        
                        for(Discount currentDiscount: registry.getDiscounts()){
                            if(productsBasket.get(p)==currentDiscount.getProduct()){
                                hasDiscount=true;
                                quantity = 1;
                                
                                for(int k=p+1;k<productsBasket.size();k++){
                                    if(productsBasket.get(p)== productsBasket.get(k)){
                                        productsBasket.remove(productsBasket.get(k));
                                        quantity++;
                                    }  
                                }
                                
                                totalCost+=currentDiscount.priceWithDiscount(quantity);
                                break;
                            }   
                        }
                        
                        if(!hasDiscount){
                            totalCost+=productsBasket.get(p).price;
                        }
                    }
                    
                    
                    //Ask the user about the day of the order
                    System.out.println("Give the date that you want to make the order.");

                    int day=0, month=0, year=0;
                    boolean pass=false;
                    Date date = null;

                    while (!pass) {

                        while (!pass){
                            try {
                                System.out.print("Give the day: ");
                                aux = sc3.nextLine();
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
                                aux = sc3.nextLine();
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
                                aux = sc3.nextLine();
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

                    Order order = new Order(totalCost,new Date(day,month,year),productsBasket);

                    customer.addOrder(order);

                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("\nChoise 2\n");

                    customer.printCustomerOrders();

                    System.out.println();
                    break;
                }
                default: {
                    File fo = new File("objects.obj");
                    writeObject(fo, registry);
                    System.out.println("\nChoise 3\nEnding programm! Thank you very much!");
                    break;
                }
            }
        }while(choice!=3);
    }
}

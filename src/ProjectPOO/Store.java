package ProjectPOO;

import java.io.*;

/**
 * Main function and file manipulation.
 */
public class Store {

    /**
     * Writes de object ob, in the file fo
     * @param fo object file to be written on
     * @param ob object to be written
     */
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

    /**
     * Starts the program by checking if there is the "objects.obj" file.
     * If it exists creates a Registry object and returns it.
     * If it doesn't exist starts reading the txt file named "start.txt".
     * In case of that file not existing, returns null, and gives an error.
     * If the file exist, creates a new Registry object and create there the data existing in the txt file.
     * @return Registry object with the file information.
     */
    private static Registry start(){
        File fo = new File("objects.obj");
        //object file

        if(fo.exists() && fo.isFile()){
            try{
                FileInputStream fis = new FileInputStream(fo);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Registry registry = (Registry)ois.readObject();

                ois.close();
                return  registry;
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error opening the file.");
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
                            case "Customer" -> {
                                String[] aux = split[6].split("/");
                                int day = Integer.parseInt(aux[0]);
                                int month = Integer.parseInt(aux[1]);
                                int year = Integer.parseInt(aux[2]);
                                Customer customer = new Customer(split[1], split[2], split[3], split[4], split[5], new Date(day, month, year), Boolean.parseBoolean(split[7]));
                                registry.getCustomers().add(customer);
                            }
                            //System.out.println(customer);
                            case "Food" -> {
                                Food food = new Food(split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]));
                                //System.out.println(food);
                                registry.getProducts().add(food);
                            }
                            case "Furniture" -> {
                                Furniture furniture = new Furniture(split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                                //System.out.println(furniture);
                                registry.getProducts().add(furniture);
                            }
                            case "Cleaning" -> {
                                Cleaning cleaning = new Cleaning(split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]));
                                //System.out.println(cleaning);
                                registry.getProducts().add(cleaning);
                            }
                            case "PayThreeTakeFour" -> {
                                Product product = registry.validProductId(Integer.parseInt(split[1]));
                                if (product == null) {
                                    System.out.println("Error with Discount. Product " + split[1] + " doesn't exist.");
                                    break;
                                }
                                PayThreeTakeFour disc = new PayThreeTakeFour(product);
                                //System.out.println(disc);
                                registry.getDiscounts().add(disc);
                            }
                            case "PayLess" -> {
                                Product product2 = registry.validProductId(Integer.parseInt(split[1]));
                                if (product2 == null) {
                                    System.out.println("Error with Discount. Product " + split[1] + " doesn't exist.");
                                    break;
                                }
                                PayLess disc2 = new PayLess(product2);
                                //System.out.println(disc2);
                                registry.getDiscounts().add(disc2);
                            }
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
     * Function that run the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Read Files
        Registry registry = start();

        if (registry != null) {
            //Log in for the customer
            Customer customer = registry.logIn();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            registry.menu(customer);
            File fo = new File("objects.obj");
            writeObject(fo, registry);
            System.out.println("\nChoise 3\nEnding programm! Thank you very much!");
        } else {
            System.out.println("Erro with the files");
        }

    }
}

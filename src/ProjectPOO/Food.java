package ProjectPOO;

/**
 * Food in the store.
 */
public class Food extends Product{
    private double calories;
    private double fat;

    /**
     * Constructor of the ProjectPOO.Product.
     * @param name of the ProjectPOO.Product.
     * @param id of the ProjectPOO.Product.
     * @param price of the ProjectPOO.Product.
     * @param stock on store.
     * @param calories of the ProjectPOO.Food.
     * @param fat percentage of the ProjectPOO.Food.
     */
    public Food(String name, int id, double price, int stock, double calories, double fat) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.calories = calories;
        this.fat = fat;
    }

    /**
     * Calculates de cost of the transport of the product.
     * @return the cost of the transport.
     */
    public double getCustToWeigth(){
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+"calories/100g("+calories+"), "+"fat("+fat+"%).";
    }
}

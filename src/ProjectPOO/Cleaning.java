package ProjectPOO;

/**
 * Cleaning products in the store.
 */
public class Cleaning extends Product{
    private int toxicity;

    /**
     * Constructor of the ProjectPOO.Product.
     * @param name of the ProjectPOO.Product.
     * @param id of the ProjectPOO.Product.
     * @param price of the ProjectPOO.Product.
     * @param stock on store.
     * @param toxicity of the ProjectPOO.Cleaning ProjectPOO.Product.
     */
    public Cleaning(String name, int id, double price, int stock, int toxicity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.toxicity = toxicity;
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
        return super.toString()+"toxicity("+toxicity+")- 0 to 10 scale.";
    }
}

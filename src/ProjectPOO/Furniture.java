package ProjectPOO;

/**
 * Furniture in the store.
 */
public class Furniture extends Product{
    private double weigth;
    private double dimension;

    /**
     * Constructor of the ProjectPOO.Product.
     * @param name of the ProjectPOO.Product.
     * @param id of the ProjectPOO.Product.
     * @param price of the ProjectPOO.Product.
     * @param stock on store.
     * @param weigth of the ProjectPOO.Furniture.
     * @param heigth of the ProjectPOO.Furniture.
     * @param width of the ProjectPOO.Furniture.
     * @param depth of the ProjectPOO.Furniture.
     */
    public Furniture(String name, int id, double price, int stock, double weigth, double heigth, double width, double depth) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.weigth = weigth;
        this.dimension = heigth*width*depth;
    }

    /**
     * Calculates de cost of the transport of the product.
     * @return the cost of the transport.
     */
    public double getCustToWeigth(){
        if(weigth > 15 ) {
            return 10;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"weigth("+weigth+"), "+"dimension("+dimension+").";
    }
}

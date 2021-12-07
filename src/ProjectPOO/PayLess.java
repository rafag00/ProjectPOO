package ProjectPOO;

import java.io.Serializable;

/**
 * Discount applied to a certain product.
 */
public class PayLess implements Discount, Serializable {
    private Product product;

    /**
     * Constructor of the discount
     * @param product ProjectPOO.Product having the discount.
     */
    public PayLess(Product product) {
        this.product = product;
    }

    /**
     * Calculates de total price with discount of the number of products
     * @param number number of products
     * @return total price with discount
     */
    @Override
    public double priceWithDiscount(int number) {
        double sum=0;
        for(int i=0; i<10 ; i++){
            if(i == number){
                break;
            }
            sum = sum + product.getPrice()*(100-(5*i))/100;
        }
        return sum;
    }

    /**
     * Returns the product associated with the discount.
     * @return ProjectPOO.Product object.
     */
    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProjectPOO.PayLess{" +
                "product=" + product +
                '}';
    }
}

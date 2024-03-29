package ProjectPOO;

import java.io.Serializable;

/**
 * Discount applied to a certain product.
 */
public class PayLess implements Discount, Serializable {
    private Product product;

    /**
     * Constructor of the discount
     * @param product Product having the discount.
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
        for(int i=0; i < number ; i++){
            if(i<10){
                sum = sum + product.getPrice()*(100-(5*i))/ 100;
            }
            else{
                sum = sum + product.getPrice()*50/100;
            }
        }
        return sum;
    }

    /**
     * Returns the product associated with the discount.
     * @return Product object.
     */
    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "PayLess{" +
                "product=" + product +
                '}';
    }
}

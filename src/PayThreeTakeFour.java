import java.io.Serializable;

public class PayThreeTakeFour implements Discount, Serializable {
    private Product product;

    public PayThreeTakeFour(Product product) {
        this.product = product;
    }

    /**
     * Calculates de total price with discount of the number of products
     * @param number number of products
     * @return total price with discount
     */
    @Override
    public double priceWithDiscount(int number) {
        int aux = (int)number/4;
        if(number%4 == 0){
            return aux*product.getPrice()*3;
        }
        else{
            return aux*product.getPrice()*3 + (number%4 * product.getPrice());
        }
    }

    @Override
    public String toString() {
        return "PayThreeTakeFour{" +
                "product=" + product +
                '}';
    }
}

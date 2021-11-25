public class PayLess implements Discount{
    private Product product;

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
}

public class PayLess extends Discount{
    public PayLess(Product product) {
        this.product = product;
    }

    //to do
    @Override
    public double priceWithDiscount(int number) {
        return -1;
    }
}

interface Discount {

    /**
     * Calculates de total price with discount of the number of products
     * @param number number of products
     * @return total price with discount
     */
    double priceWithDiscount(int number);

    /**
     * Returns the product associated with the discount.
     * @return Product object.
     */
    Product getProduct();
}

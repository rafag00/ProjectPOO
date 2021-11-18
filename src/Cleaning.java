public class Cleaning extends Product{
    private int toxicity;

    public Cleaning(String name, int id, double price, int stock, int toxicity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.toxicity = toxicity;
    }
}

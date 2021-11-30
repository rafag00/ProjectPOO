public class Cleaning extends Product{
    private int toxicity;

    public Cleaning(String name, int id, double price, int stock, int toxicity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.toxicity = toxicity;
    }

    public double getCustToWeigth(){
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+"toxicity("+toxicity+")- 0 to 10 scale.";
    }
}

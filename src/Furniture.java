public class Furniture extends Product{
    private double weigth;
    private double dimension;

    public Furniture(String name, int id, double price, int stock, double weigth, double heigth, double width, double depth) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.weigth = weigth;
        this.dimension = heigth*width*depth;
    }
}

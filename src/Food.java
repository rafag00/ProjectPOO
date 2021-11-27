import java.io.Serializable;

public class Food extends Product{
    private double calories;
    private double fat;

    public Food(String name, int id, double price, int stock, double calories, double fat) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.calories = calories;
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Food{" +
                "calories=" + calories +
                ", fat=" + fat +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

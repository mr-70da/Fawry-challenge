package Products;

public class Laptop extends Product implements ShippableProduct {
    private double weight;

    public Laptop(long quantity, String name, double price, double weight) {
        super(quantity, name, price);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}

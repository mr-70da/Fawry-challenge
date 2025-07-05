package Products;

import java.time.LocalDate;

public class Milk extends Product implements ShippableProduct, ExpirableProduct {
    private double weight;
    private LocalDate expirationDate;

    public Milk(long quantity, String name, double price, double weight, LocalDate expirationDate) {
        super(quantity, name, price);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

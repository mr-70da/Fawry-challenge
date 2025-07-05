package Products;

import java.time.LocalDate;

public class Cookies extends Product implements ShippableProduct, ExpirableProduct{
    private LocalDate expirationDate;
    private double weight;
    public Cookies(long quantity, String name, double price , LocalDate expirationDate , double weight) {
        super(quantity, name, price);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

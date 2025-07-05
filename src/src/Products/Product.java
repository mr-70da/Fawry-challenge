package Products;
import Exceptions.AvailabilityException;
//Entity
public abstract class Product {
    private long availableStock;
    private String name;
    private double price;

    public Product(long quantity, String name, double price) {
        this.availableStock = quantity;
        this.name = name;
        this.price = price;
    }

    public long getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(long availableStock) {
        this.availableStock = availableStock;
    }
    public void addToStock(long quantity) {
        this.availableStock+=quantity;
    }
     public void removeFromStock(long quantity)throws Exception {
        if(this.availableStock < quantity){
            throw new AvailabilityException(this);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

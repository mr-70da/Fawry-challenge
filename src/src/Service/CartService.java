package Service;

import Exceptions.*;
import Products.ExpirableProduct;
import Products.Product;
import User.Customer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CartService {
    public Customer customer;
    public int itemsCount;
    HashMap<Product,Integer> cart;
    public CartService(Customer customer) {
        this.customer = customer;
        this.cart = new HashMap<Product, Integer>();
        this.itemsCount = 0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getItemsCount() {
        return itemsCount;
    }


    public void addProduct(Product product, int quantity) throws Exception{
        if(quantity<1){
            throw new InvalidQuantityException();
        }
        if(product.getAvailableStock()<quantity){
            throw new AvailabilityException(product);
        }else if(product instanceof ExpirableProduct){
            if(((ExpirableProduct) product).getExpirationDate().isAfter(LocalDate.now())){
                throw new ExpirationException(product);
            }

        }
        product.removeFromStock(quantity);
        cart.put(product,quantity);
        itemsCount+=quantity;
    }
    public void removeProduct(String productName) throws Exception{
        productName = productName.toLowerCase();
        for(Map.Entry<Product,Integer> item : this.cart.entrySet()){
            if(productName.equals(item.getKey().getName().toLowerCase())){
                itemsCount-=item.getValue();
                item.getKey().addToStock(item.getValue());
                this.cart.remove(item);
                return;
            }
        }
        throw new NotFoundException(productName);

    }
    public double evaluate(){
        double totalCost = 0;
        for(Map.Entry<Product,Integer> item : this.cart.entrySet()){
            totalCost+=item.getKey().getPrice()*item.getValue();
        }
        return totalCost;
    }

    public HashMap<Product, Integer> getCart() {
        return cart;
    }
}

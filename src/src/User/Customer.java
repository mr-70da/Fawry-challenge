package User;

import Service.CartService;

//Entity
public class Customer {

    private CartService cart;
    private double balance;
    private String name;
    private String phoneNumber;
    private double customerBalance;
    private String address;

    public Customer(CartService cart, String name,
                    String phoneNumber, double customerBalance,
                    String address) {
        this.cart = cart;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.customerBalance = customerBalance;
        this.address = address;
    }

    public CartService getCart() {
        return cart;
    }

    public void addItemToCart(CartService cart) {
        this.cart = cart;
    }
    public void removeItemToCart(CartService cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

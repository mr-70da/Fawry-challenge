package Main;

import Products.*;
import Service.*;
import User.Customer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            //expired
            //Milk milk = new Milk(10, "Milk", 20.0, 1.0, LocalDate.now().plusDays(5));
            Laptop laptop = new Laptop(5, "Laptop", 5000.0, 2.5);
            Book book = new Book(20, "Book", 50.0, 0.7);
            MobileScratchCard mobileScratchCard = new MobileScratchCard(1, "Scratch Card", 30.0, 0.5, LocalDate.now().plusDays(3));


            CartService cartService = new CartService(null);


            Customer customer = new Customer(cartService, "Ahmed", "01000000000", 6000.0, "123 Cairo Street");


            cartService.setCustomer(customer);

            //cartService.addProduct(milk, 2);
            cartService.addProduct(laptop, 1);
            cartService.addProduct(book, 3);
            //not enough in stock
            //cartService.addProduct(mobileScratchCard, 4);


            CheckoutService.checkout(customer, cartService);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

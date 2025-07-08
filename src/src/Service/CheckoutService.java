package Service;

import Products.Product;
import Products.ShippableProduct;
import User.Customer;
import Exceptions.EmptyCartException;
import Exceptions.InsufficientFundException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutService {

    public static void checkout(Customer customer, CartService cartService) throws Exception {
        if (cartService.getItemsCount() == 0) {
            throw new EmptyCartException();
        } else if (customer.getCustomerBalance() < cartService.evaluate()) {
            throw new InsufficientFundException();
        }
        ShippingService shippingService = new ShippingService(0);
        HashMap<Product, Integer> shippingProducts = new HashMap<Product, Integer>();

        for (Map.Entry<Product, Integer> item : cartService.getCart().entrySet()) {
            if (item.getKey() instanceof ShippableProduct) {
                shippingProducts.put(item.getKey(), item.getValue());
            }
        }
        shippingService.shippingRecipet(shippingProducts);
        System.out.println("** Checkout receipt **");

        for (Map.Entry<Product, Integer> item : cartService.getCart().entrySet()) {
            System.out.printf("%dx %-13s", item.getValue(), item.getKey().getName());
            System.out.println(item.getKey().getPrice() * item.getValue());
        }

        System.out.println("----------------------");

        double subtotal = cartService.evaluate();
        double shippingCost = shippingService.getShippingCost();
        double total = subtotal + shippingCost;

        System.out.printf("%-17s", "Subtotal");
        System.out.println(subtotal);
        System.out.printf("%-17s", "Shipping");
        System.out.println(shippingCost);
        System.out.printf("%-17s", "Amount");
        System.out.println(total);

    }
}

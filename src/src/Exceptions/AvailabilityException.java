package Exceptions;

import Products.Product;

public class AvailabilityException extends Exception {
    public AvailabilityException( Product product)
    {
        super(STR."Only \{product.getAvailableStock()} of \{product.getName()} is available in stock.");
    }
}

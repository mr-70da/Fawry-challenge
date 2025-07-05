package Exceptions;

import Products.Product;

public class ExpirationException extends Exception{
    public ExpirationException(Product product)
    {
        super(STR."Sorry the \{product.getName()} has expired.");
    }
}

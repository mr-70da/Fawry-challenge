package Exceptions;

import Products.Product;

public class NotFoundException extends Exception{
    public NotFoundException(String productName){
        super(STR."There is no such product with this name \"\{productName}\"");
    }
}

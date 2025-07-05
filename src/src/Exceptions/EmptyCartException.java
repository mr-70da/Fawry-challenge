package Exceptions;

public class EmptyCartException extends Exception{
    public EmptyCartException(){
        super("Can not proceed to checkout as you did not add any products.");
    }
}

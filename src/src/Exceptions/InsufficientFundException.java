package Exceptions;

public class InsufficientFundException extends Exception{
    public InsufficientFundException(){
        super("Sorry You do not have sufficient fund to complete the checkout.");
    }

}

package Exceptions;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException() {
        super("You should at least add one item.");
    }
}

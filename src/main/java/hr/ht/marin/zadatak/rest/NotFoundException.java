package hr.ht.marin.zadatak.rest;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

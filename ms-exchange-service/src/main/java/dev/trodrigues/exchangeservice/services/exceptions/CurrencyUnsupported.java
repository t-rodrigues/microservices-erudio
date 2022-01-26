package dev.trodrigues.exchangeservice.services.exceptions;

public class CurrencyUnsupported extends RuntimeException {

    public CurrencyUnsupported(String message) {
        super(message);
    }

}

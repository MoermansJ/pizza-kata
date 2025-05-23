package be.pizza.kata.pizzaorder.exception;

public class PizzaOrderValidationException extends RuntimeException {

    public PizzaOrderValidationException(String message) {
        super(message);
    }
}

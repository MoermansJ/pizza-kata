package be.pizza.kata.pizzaorder.fixture;

import java.util.List;

public class PizzaOrderExceptionFixture {
    private static final String PIZZA_MESSAGE = "Pizza cannot be ";
    private static final String SIZE_MESSAGE = "Size cannot be ";
    private static final String NULL = "null";

    public static List<String> nullPizzaAndNullPizzaSizeErrors() {
        var pizzaError = PIZZA_MESSAGE + NULL;
        var sizeError = SIZE_MESSAGE + NULL;

        return List.of(pizzaError, sizeError);
    }
}

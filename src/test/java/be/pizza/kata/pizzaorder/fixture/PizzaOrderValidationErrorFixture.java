package be.pizza.kata.pizzaorder.fixture;

import java.util.List;

public class PizzaOrderValidationErrorFixture {
    private static final String PIZZA_PREFIX = "Pizza cannot be ";
    private static final String SIZE_PREFIX = "Size cannot be ";
    private static final String NULL = "null";

    public static List<String> nullPizzaAndNullPizzaSizeErrors() {
        var pizzaError = PIZZA_PREFIX + NULL;
        var sizeError = SIZE_PREFIX + NULL;

        return List.of(pizzaError, sizeError);
    }
}

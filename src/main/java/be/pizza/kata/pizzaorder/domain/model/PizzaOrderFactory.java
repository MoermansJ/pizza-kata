package be.pizza.kata.pizzaorder.domain.model;

import be.pizza.kata.pizzaorder.controller.model.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;

public class PizzaOrderFactory {
    private static final String DELIMITER = "," + System.lineSeparator();

    public static PizzaOrder createFrom(PizzaOrderRequest request) {
        var notification = request.validate();

        if (notification.hasErrors()) {
            var message = String.join(DELIMITER, notification.getErrors());
            throw new PizzaOrderException(message);
        }

        var pizza = Pizza.fromString(request.pizza());
        var size = PizzaSize.fromString(request.size());

        return new PizzaOrder(pizza, size);
    }
}

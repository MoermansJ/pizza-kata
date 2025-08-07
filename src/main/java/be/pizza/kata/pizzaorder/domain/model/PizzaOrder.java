package be.pizza.kata.pizzaorder.domain;


import be.pizza.kata.commons.notification.Validatable;
import be.pizza.kata.pizzaorder.adapter.controller.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.domain.validation.Notification;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;

public class PizzaOrder implements Validatable {

    private Pizza pizza;
    private PizzaSize size;

    public PizzaOrder(PizzaOrderRequest request) {
        try {
            this.pizza = Pizza.fromString(request.pizza());
        } catch (PizzaOrderException ignored) {
        }

        try {
            this.size = PizzaSize.fromString(request.size());
        } catch (PizzaOrderException ignored) {
        }
    }

    public Pizza getPizza() {
        return pizza;
    }

    public PizzaSize getSize() {
        return size;
    }

    @Override
    public Notification validate() {
        var notification = Notification.empty();

        if (pizza == null) {
            notification.addError("Pizza cannot be " + pizza);
        }

        if (size == null ) {
            notification.addError("Size cannot be " + size);
        }

        return notification;
    }
}

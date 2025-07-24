package be.pizza.kata.pizzaorder.controller.model;

import be.pizza.kata.commons.notification.Notification;
import be.pizza.kata.commons.notification.Validatable;
import be.pizza.kata.pizzaorder.domain.model.Pizza;
import be.pizza.kata.pizzaorder.domain.model.PizzaSize;

public record PizzaOrderRequest(String pizza, String size) implements Validatable {
    @Override
    public Notification validate() {
        var notification = new Notification();

        if (pizza == null || !Pizza.isValid(pizza)) {
            notification.addError("Pizza cannot be " + pizza);
        }
        if (size == null || !PizzaSize.isValid(size)) {
            notification.addError("Size cannot be " + size);
        }

        return notification;
    }
}

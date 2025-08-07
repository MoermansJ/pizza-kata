package be.pizza.kata.commons.notification;

import be.pizza.kata.pizzaorder.domain.validation.Notification;

public interface Validatable {
    Notification validate();
}

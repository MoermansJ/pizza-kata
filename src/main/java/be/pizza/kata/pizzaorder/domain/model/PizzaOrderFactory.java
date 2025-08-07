package be.pizza.kata.pizzaorder.domain.model;

import be.pizza.kata.pizzaorder.adapter.controller.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.domain.validation.Creation;

public class PizzaOrderFactory {

    public static Creation<PizzaOrder> create(PizzaOrderRequest request) {
        var order = new PizzaOrder(request);
        return Creation.of(order, order.validate());
    }
}

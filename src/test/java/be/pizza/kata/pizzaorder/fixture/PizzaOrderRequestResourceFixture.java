package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.adapter.controller.PizzaOrderRequestResource;

public class PizzaOrderRequestResourceFixture {
    private static final String MARGHERITA = "Margherita";
    private static final String MEDIUM = "Medium";
    private static final String EMPTY = "";

    public static PizzaOrderRequestResource mediumMargherita() {
        return new PizzaOrderRequestResource(MARGHERITA, MEDIUM);
    }

    public static PizzaOrderRequestResource emptyPizzaAndEmptySize() {
        return new PizzaOrderRequestResource(EMPTY, EMPTY);
    }
}

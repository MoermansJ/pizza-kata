package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.adapter.controller.PizzaOrderRequest;

public class PizzaOrderRequestFixture {
    private static final String MARGHERITA = "Margherita";
    private static final String MEDIUM = "Medium";
    private static final String EMPTY = "";

    public static PizzaOrderRequest mediumMargherita() {
        return new PizzaOrderRequest(MARGHERITA, MEDIUM);
    }

    public static PizzaOrderRequest emptyPizzaAndEmptyPizzaSize() { return new PizzaOrderRequest(EMPTY, EMPTY); }
}

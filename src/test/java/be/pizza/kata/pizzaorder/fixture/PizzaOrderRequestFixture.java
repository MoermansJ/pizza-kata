package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.controller.model.PizzaOrderRequest;

public class PizzaOrderRequestFixture {
    private static final String PIZZA = "Margherita";
    private static final String SIZE = "Medium";
    private static final String BLANK = "";

    public static PizzaOrderRequest mediumMargheritaRequest() {
        return new PizzaOrderRequest(PIZZA, SIZE);
    }

    public static PizzaOrderRequest blankPizzaAndBlankSizeRequest() { return new PizzaOrderRequest(BLANK, BLANK); }
}

package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveRequest;

public class PizzaOrderCreateRequestFixture {
    private static final String PIZZA = "Margherita";
    private static final String SIZE = "Medium";

    public static PizzaOrderSaveRequest validRequest() {
        return new PizzaOrderSaveRequest(PIZZA, SIZE);
    }

    public static PizzaOrderSaveRequest invalidRequest() {
        return new PizzaOrderSaveRequest("", "");
    }
}

package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveRequest;

public class PizzaOrderSaveRequestFixture {
    private static final String PIZZA = "Margherita";
    private static final String SIZE = "Medium";
    private static final String BLANK = "";

    public static PizzaOrderSaveRequest mediumMargheritaRequest() {
        return new PizzaOrderSaveRequest(PIZZA, SIZE);
    }

    public static PizzaOrderSaveRequest blankPizzaAndBlankSizeRequest() { return new PizzaOrderSaveRequest(BLANK, BLANK); }
}

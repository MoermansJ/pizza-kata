package be.pizza.kata.pizzaorder.adapter;

public class PizzaOrderRequestFixture {
    private static final String MARGHERITA = "Margherita";
    private static final String MEDIUM = "Medium";
    private static final String BLANK = "";

    public static PizzaOrderRequest mediumMargheritaRequestResource() {
        return new PizzaOrderRequest(MARGHERITA, MEDIUM);
    }

    public static PizzaOrderRequest blankPizzaAndBlankSizeRequestResource() { return new PizzaOrderRequest(BLANK, BLANK); }
}

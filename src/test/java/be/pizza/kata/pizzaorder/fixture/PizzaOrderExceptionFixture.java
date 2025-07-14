package be.pizza.kata.pizzaorder.fixture;

public class PizzaOrderExceptionFixture {
    private static final String DELIMITER = "," + System.lineSeparator();
    private static final String PIZZA_MESSAGE = "Pizza cannot be ";
    private static final String SIZE_MESSAGE = "Size cannot be ";
    private static final String BLANK = "";

    public static String blankPizzaAndBlankPizzaSizeMessage() {
        return PIZZA_MESSAGE + BLANK + DELIMITER +
                SIZE_MESSAGE + BLANK;
    }
}

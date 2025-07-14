package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.pizzaorder.exception.PizzaOrderException;

public enum PizzaSize {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String value;

    PizzaSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static PizzaSize fromString(String value) {
        return java.util.Arrays.stream(PizzaSize.values())
                .filter(size -> size.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new PizzaOrderException("No PizzaSize found with value: " + value));
    }

    public static boolean isValid(String value) {
        try {
            fromString(value);
            return true;
        } catch (PizzaOrderException e) {
            return false;
        }
    }
}

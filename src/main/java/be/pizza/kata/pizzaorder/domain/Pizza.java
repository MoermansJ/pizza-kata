package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.pizzaorder.exception.PizzaOrderException;

public enum Pizza {
    MARGHERITA("Margherita"),
    PEPPERONI("Pepperoni"),
    FOUR_CHEESE("Four Cheese"),
    VEGGIE("Veggie");

    private final String value;

    Pizza(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static Pizza fromString(String value) {
        return java.util.Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new PizzaOrderException("No pizza found with value: " + value));
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
